package com.rk.springmavendockerbasecore.rest;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@NoArgsConstructor
@Service
public class K8sResourceService {

    public List<String> getPods(String namespace) {
        return Optional.ofNullable(namespace)
                .map(n -> generatePodsForNamespace(n, 2))
                .orElse(generateAllPods(10));
    }

    private List<String> generatePodsForNamespace(String namespace, int count) {
        return IntStream
                .range(0, count)
                .boxed()
                .map(i -> String.format("%s-pod-%s", namespace, i))
                .toList();
    }

    private List<String> generateAllPods(int count) {
        return IntStream
                .range(0, count)
                .boxed()
                .map(i -> String.format("pod-%s", i))
                .toList();
    }
}
