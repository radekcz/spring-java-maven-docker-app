package com.rk.springmavendockerbasecore.rest;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

@NoArgsConstructor
@Service
public class K8sResourceService {

    public List<String> getPods(String namespace) {
        return Optional.ofNullable(namespace)
                .map(n -> generatePodsForNamespace(2, n))
                .orElse(generateAllPods(10));
    }

    private List<String> generatePodsForNamespace(int count, String namespace) {
        return generatePods(count, i -> String.format("%s-pod-%s", namespace, i));
    }

    private List<String> generateAllPods(int count) {
        return generatePods(count, i -> String.format("pod-%s", i));
    }

    private List<String> generatePods(int count, Function<Integer, String> generateName) {
        return IntStream
                .range(0, count)
                .boxed()
                .map(generateName)
                .toList();
    }

}
