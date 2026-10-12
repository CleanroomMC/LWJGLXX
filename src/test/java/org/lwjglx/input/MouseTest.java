package org.lwjglx.input;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.ForgeEarlyConfig;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MouseTest {

    @BeforeEach
    void resetScrollState() {
        while (Mouse.next()) {}
        Mouse.getDWheel();
        Mouse.fractionalWheelPosition = 0.0;
        Mouse.totalScrollAmount = 0.0;
        ForgeEarlyConfig.INPUT_INVERT_WHEEL = false;
        ForgeEarlyConfig.INPUT_SCROLL_SPEED = 1.0;
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1})
    void oneNotchProducesOneStep(int direction) {
        Mouse.addWheelEvent(direction);

        assertThat(wheelEvents()).containsExactly(direction);
        assertThat(Mouse.getDWheel()).isEqualTo(direction);
        assertThat(Mouse.getDWheel()).isZero();
    }

    @ParameterizedTest
    @CsvSource({"0.9, -1", "-0.9, 1", "0.96, -0.96", "-0.96, 0.96", "1.2, -1", "-1.2, 1"})
    void fractionalNotchAndDirectionReversalRemainResponsive(double delta, double opposite) {
        int direction = (int) Math.signum(delta);
        Mouse.addWheelEvent(delta);
        assertThat(wheelEvents()).containsExactly(direction);

        Mouse.addWheelEvent(opposite);
        assertThat(wheelEvents()).containsExactly(-direction);
        assertThat(Mouse.getDWheel()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1})
    void smoothSubstepsKeepTheirCombinedDistance(int direction) {
        for (int i = 0; i < 4; i++) {
            Mouse.addWheelEvent(0.25 * direction);
        }

        assertThat(wheelEvents()).containsExactly(direction);
        assertThat(Mouse.getDWheel()).isEqualTo(direction);
        assertThat(Mouse.totalScrollAmount).isEqualTo((double) direction);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1})
    void subthresholdRemainderDoesNotSwallowAnOppositeNotch(int direction) {
        Mouse.addWheelEvent(0.49 * direction);
        assertThat(wheelEvents()).isEmpty();

        Mouse.addWheelEvent(-direction);
        assertThat(wheelEvents()).containsExactly(-direction);
        assertThat(Mouse.getDWheel()).isEqualTo(-direction);
    }

    @Test
    void zeroInputDoesNotRepeatAHalfStep() {
        Mouse.addWheelEvent(0.5);
        assertThat(wheelEvents()).containsExactly(1);

        Mouse.addWheelEvent(0.0);
        Mouse.addWheelEvent(-0.0);
        assertThat(wheelEvents()).isEmpty();
        assertThat(Mouse.getDWheel()).isEqualTo(1);

        Mouse.addWheelEvent(0.5);
        assertThat(wheelEvents()).isEmpty();
        assertThat(Mouse.totalScrollAmount).isEqualTo(1.0);
    }

    @Test
    void negativeHalfStepIsRetainedUntilTheNextSubstep() {
        Mouse.addWheelEvent(-0.5);
        assertThat(wheelEvents()).isEmpty();

        Mouse.addWheelEvent(-0.5);
        assertThat(wheelEvents()).containsExactly(-1);
        assertThat(Mouse.getDWheel()).isEqualTo(-1);
    }

    @Test
    void speedAndInversionApplyBeforeRounding() {
        ForgeEarlyConfig.INPUT_SCROLL_SPEED = 2.0;
        ForgeEarlyConfig.INPUT_INVERT_WHEEL = true;

        Mouse.addWheelEvent(0.45);

        assertThat(wheelEvents()).containsExactly(-1);
        assertThat(Mouse.getDWheel()).isEqualTo(-1);
        assertThat(Mouse.totalScrollAmount).isEqualTo(-0.9);
    }

    @Test
    void zeroSpeedPreservesPendingDistance() {
        Mouse.addWheelEvent(0.25);
        ForgeEarlyConfig.INPUT_SCROLL_SPEED = 0.0;
        Mouse.addWheelEvent(1.0);
        ForgeEarlyConfig.INPUT_SCROLL_SPEED = 1.0;
        Mouse.addWheelEvent(0.25);

        assertThat(wheelEvents()).containsExactly(1);
        assertThat(Mouse.getDWheel()).isEqualTo(1);
        assertThat(Mouse.totalScrollAmount).isEqualTo(0.5);
    }

    private List<Integer> wheelEvents() {
        List<Integer> events = new ArrayList<>();
        while (Mouse.next()) {
            events.add(Mouse.getEventDWheel());
            assertThat(Mouse.getEventButton()).isEqualTo(-1);
            assertThat(Mouse.getEventButtonState()).isFalse();
        }
        return events;
    }
}
