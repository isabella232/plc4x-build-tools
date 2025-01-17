/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.plc4x.plugins.codegenerator.types.definitions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface DiscriminatedComplexTypeDefinition extends ComplexTypeDefinition {

    List<String> getDiscriminatorValues();

    /**
     * @return a {@link Map} mapping discriminator names to discriminator values.
     */
    default Map<String, String> getDiscriminatorMap() {
        // TODO: check why the names method is above and why the names method looks at the parent.
        final List<String> discriminatorNames = getDiscriminatorNames();
        final Map<String, String> discriminatorValues = new LinkedHashMap<>();
        for (int i = 0; i < discriminatorNames.size(); i++) {
            String discriminatorValue;
            if (i < getDiscriminatorValues().size()) {
                discriminatorValue = getDiscriminatorValues().get(i);
            } else {
                discriminatorValue = null;
            }
            discriminatorValues.put(discriminatorNames.get(i), discriminatorValue);
        }
        return discriminatorValues;
    }
}
