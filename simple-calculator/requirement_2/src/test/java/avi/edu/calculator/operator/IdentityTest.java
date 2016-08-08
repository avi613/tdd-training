package avi.edu.calculator.operator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IdentityTest {
    Identity identity = new Identity();

    @Test
    public void should_return_0_when_input_is_null() {
        assertThat(identity.operate(null)).isEqualTo(0);
    }

    @Test
    public void should_return_the_only_element_of_a_singleton() {
        assertThat(identity.operate(new int[]{5})).isEqualTo(5);
        assertThat(identity.operate(new int[]{36})).isEqualTo(36);
    }
}
