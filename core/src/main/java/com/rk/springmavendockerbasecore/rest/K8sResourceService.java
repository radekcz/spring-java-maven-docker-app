package com.rk.springmavendockerbasecore.rest;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Service
public class K8sResourceService {

    public List<String> getPods(String namespace) {
        return Optional.ofNullable(namespace)
                .map(n -> List.of(generatePod(n, 1), generatePod(n, 2)))
                .orElse(List.of("pod1", "pod2", "pod3"));
    }

    private String generatePod(String namespace, int rank) {
        return String.format("%s-pod-%s", namespace, rank);
    }
}
