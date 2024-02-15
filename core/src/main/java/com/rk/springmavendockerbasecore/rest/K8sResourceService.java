package com.rk.springmavendockerbasecore.rest;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor
@Service
public class K8sResourceService {

    public List<String> getPods(String namespace) {
        return Optional.ofNullable(namespace)
                .map(n -> generatePods(n, 2))
                .orElse(List.of("pod1", "pod2", "pod3"));
    }

    private List<String> generatePods(String namespace, int count) {
        return IntStream
                .range(0, count)
                .boxed()
                .map(i -> String.format("%s-pod-%s", namespace, i))
                .collect(Collectors.toList());
    }
}
