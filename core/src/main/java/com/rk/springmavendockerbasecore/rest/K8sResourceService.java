package com.rk.springmavendockerbasecore.rest;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class K8sResourceService {

    public List<String> getPods() {
        return List.of("pod1", "pod2", "pod3");
    }

}
