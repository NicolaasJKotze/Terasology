// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.unittest.stubs;

import org.terasology.gestalt.entitysystem.component.Component;
import org.terasology.reflection.MappedContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfObjectComponent implements Component<ListOfObjectComponent> {
    public String shortName;
    public List<SubElement> elements = new ArrayList<>();

    @Override
    public void copy(ListOfObjectComponent other) {
        this.shortName = other.shortName;
        this.elements = other.elements.stream().map((subElement -> {
            SubElement newSub = new SubElement();
            newSub.id = subElement.id;
            newSub.type = subElement.type;
            return newSub;
        })).collect(Collectors.toList());
    }

    @MappedContainer
    public static class SubElement {
        public String id;
        public String type;
    }
}
