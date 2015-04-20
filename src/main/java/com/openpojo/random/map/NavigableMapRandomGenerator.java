/*
 * Copyright (c) 2010-2015 Osman Shoukry
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as published by
 *    the Free Software Foundation, either version 3 of the License or any
 *    later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.openpojo.random.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.openpojo.random.exception.RandomGeneratorException;
import com.openpojo.random.map.util.AbstractMapRandomGenerator;
import com.openpojo.random.map.util.MapHelper;
import com.openpojo.random.util.SerializableComparableObject;
import com.openpojo.reflection.java.load.ClassUtil;

/**
 * @author oshoukry
 */
public class NavigableMapRandomGenerator extends AbstractMapRandomGenerator {
    private static final String TYPE = "java.util.NavigableMap";

    public static NavigableMapRandomGenerator getInstance() {
        return Instance.INSTANCE;
    }

    public Collection<Class<?>> getTypes() {
        List<Class<?>> types = new ArrayList<Class<?>>();
        if (ClassUtil.isClassLoaded(TYPE))
            types.add(ClassUtil.loadClass(TYPE));
        return types;
    }

    @Override
    protected Map getBasicInstance(Class<?> type) {
        if (!isAssignableTo(type))
            throw RandomGeneratorException.getInstance("Invalid type requested [" + type + "]");
        return MapHelper.buildMap(new TreeMap(), SerializableComparableObject.class,
                SerializableComparableObject.class);
    }

    private NavigableMapRandomGenerator() {
    }

    private static class Instance {
        private static final NavigableMapRandomGenerator INSTANCE = new NavigableMapRandomGenerator();
    }
}