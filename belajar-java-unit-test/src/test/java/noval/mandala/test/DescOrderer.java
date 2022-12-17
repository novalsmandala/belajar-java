package noval.mandala.test;

import org.apiguardian.api.API;
import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Comparator;
import java.util.Optional;

public class DescOrderer implements MethodOrderer {

    public DescOrderer() {
    }

    @Override
    public void orderMethods(MethodOrdererContext context) {
        context.getMethodDescriptors().sort(new Comparator<MethodDescriptor>() {
            @Override
            public int compare(MethodDescriptor o1, MethodDescriptor o2) {
                return o1.getDisplayName().compareTo(o2.getDisplayName());
            }
        });
    }

    @Override
    public Optional<ExecutionMode> getDefaultExecutionMode() {
        return MethodOrderer.super.getDefaultExecutionMode();
    }
}
