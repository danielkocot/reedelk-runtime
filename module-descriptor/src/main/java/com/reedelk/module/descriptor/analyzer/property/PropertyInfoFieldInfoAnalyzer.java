package com.reedelk.module.descriptor.analyzer.property;

import com.reedelk.module.descriptor.analyzer.commons.ScannerUtils;
import com.reedelk.module.descriptor.analyzer.component.ComponentAnalyzerContext;
import com.reedelk.module.descriptor.model.ComponentPropertyDescriptor;
import com.reedelk.runtime.api.annotation.PropertyInfo;
import io.github.classgraph.FieldInfo;

public class PropertyInfoFieldInfoAnalyzer implements FieldInfoAnalyzer {
    @Override
    public void handle(FieldInfo propertyInfo, ComponentPropertyDescriptor.Builder builder, ComponentAnalyzerContext context) {
        String propertyToolTipInfo =
                ScannerUtils.annotationValueOrDefaultFrom(propertyInfo, PropertyInfo.class, null);
        builder.propertyInfo(propertyToolTipInfo);
    }
}