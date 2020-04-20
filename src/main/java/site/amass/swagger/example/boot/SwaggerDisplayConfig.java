package site.amass.swagger.example.boot;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.type.MapType;
import com.google.common.base.Optional;
import io.swagger.annotations.ApiModelProperty;

import static springfox.documentation.schema.Annotations.findPropertyAnnotation;
import static springfox.documentation.swagger.schema.ApiModelProperties.findApiModePropertyAnnotation;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ModelPropertyBuilder;
import springfox.documentation.schema.Annotations;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;
import springfox.documentation.swagger.schema.ApiModelProperties;


/**
 * 对swagger展示进行修改 1. 数字、Boolean属性设置默认的example 2. 支持将枚举变量的描述按照枚举类定义展示
 *
 * @see SwaggerDisplayEnum
 * @see ApiModelProperty
 */
//@Component
//@Primary
@Slf4j
public class SwaggerDisplayConfig implements ModelPropertyBuilderPlugin {

    @Override
    public void apply(ModelPropertyContext context) {
        //获取当前字段的类型
    	System.out.println(context.getBuilder().qualifiedType("map<string,integer>").build().getQualifiedType());
    	if ( context.getBeanPropertyDefinition().isPresent()) {
			
    		BeanPropertyDefinition definition = context.getBeanPropertyDefinition().get();
    		JavaType javaType = definition.getPrimaryType();
    		if (javaType instanceof MapType) {
    			System.out.println("22222222222222222");
    			System.out.println(javaType.getKeyType().getRawClass().getSimpleName());
    			System.out.println(javaType.getContentType().getTypeName());
//			Optional<AnnotatedElement> annotation = context.getAnnotatedElement();
//			System.out.println(annotation);
//			if (annotation.isPresent()) {
//				System.out.println("-----------------");
//				System.out.println(annotation.get());
//			}
//			Optional<ApiModelProperty> annotation = Optional.absent();
//			
//			if (context.getAnnotatedElement().isPresent()) {
//				annotation = annotation.or(findApiModePropertyAnnotation(context.getAnnotatedElement().get()));
//			}
//			if (context.getBeanPropertyDefinition().isPresent()) {
//				annotation = annotation.or(findPropertyAnnotation(
//						context.getBeanPropertyDefinition().get(),
//						ApiModelProperty.class));
//			}
//			if (annotation.isPresent()) {
//				context.getBuilder().type(context.getResolver().resolve(Map.class, String.class,Integer.class));
//			}
    		}
		}
//    	System.out.println(definition.getPrimaryType());
//        final Class fieldType = context.getBeanPropertyDefinition().get().getField().getRawType();
////        if (fieldType.isAssignableFrom(HashMap.class)) {
////        	System.out.println("+++++++++++++++++++++");
////        	Type type =  fieldType.getGenericSuperclass();
////        	if (type instanceof ParameterizedType) {
////        		ParameterizedType parameterizedType = (ParameterizedType) type;
////        		System.out.println(parameterizedType.getActualTypeArguments()[0]);
////        	}
////        }
////        System.out.println(fieldType);
//        //设置对数字的字段设置默认的example
//        setDefaultExample(context, fieldType);
//
//        //为枚举字段设置注释
//        descForEnumFields(context, fieldType);
    }
//public static void main(String[] args) {
//	HashMap<String, String> map = new HashMap<String,String>();
////	Type type = map.getClass().getGenericSuperclass();
////	ParameterizedType pt = (ParameterizedType )type;
////	/*得到父类(参数化类型)中的泛型(实际类型参数)的实际类型。
////	getActualTypeArguments()返回一个Type数组，之所以返回Type数组,是因为一个类上有可能出现多个泛型，比如:Map<Integer,String>
////	*/
////	Type [] actualTypes = pt.getActualTypeArguments();
////	for (Type type2 : actualTypes) {
////		System.out.println(type2.getClass().toGenericString());
////	}
//	
//	 Type type =  map.getClass().getGenericSuperclass();
//	    if (type instanceof ParameterizedType) {
//	      ParameterizedType parameterizedType = (ParameterizedType) type;
//	      System.out.println(parameterizedType.getActualTypeArguments()[0]);
//	    }
////	System.out.println(Arrays.asList(actualTypes));//结果:C    
//}
    /**
     * 为枚举字段设置注释
     */
    private void descForEnumFields(ModelPropertyContext context, Class<?> fieldType) {
    	 Optional<ApiModelProperty> annotation = Optional.absent();
//        Optional<ApiModelProperty> annotation = Optional.absent();
//
        if (context.getAnnotatedElement().isPresent()) {
            annotation = annotation
                .or(ApiModelProperties.findApiModePropertyAnnotation(context.getAnnotatedElement().get()));
        }
        if (context.getBeanPropertyDefinition().isPresent()) {
            annotation = annotation.or(Annotations.findPropertyAnnotation(
                context.getBeanPropertyDefinition().get(),
                ApiModelProperty.class));
        }
        //没有@ApiModelProperty 或者 notes 属性没有值，直接返回
        if (!annotation.isPresent()) {
            return;
        }
//        if (fieldType.isAssignableFrom(Map.class)) {
//        	System.out.println("=========================================================");
//        	System.out.println(fieldType);
//        	System.out.println(Arrays.asList(fieldType.getClass().getGenericSuperclass()));
//        	Type type = fieldType.getGenericSuperclass();
//        	ParameterizedType pt = (ParameterizedType )type;
//        	/*得到父类(参数化类型)中的泛型(实际类型参数)的实际类型。
//        	getActualTypeArguments()返回一个Type数组，之所以返回Type数组,是因为一个类上有可能出现多个泛型，比如:Map<Integer,String>
//        	*/
//        	Type [] actualTypes = pt.getActualTypeArguments();
//        	System.out.println(Arrays.asList(actualTypes));//结果:C        	
//        	System.out.println(Arrays.asList(fieldType.getClass().getGenericInterfaces()));
//		}
        
//
//        //@ApiModelProperties中的notes指定的class类型
//        Class rawPrimaryType;
//        try {
//            rawPrimaryType = Class.forName((annotation.get()).notes());
//        } catch (ClassNotFoundException e) {
//            //如果指定的类型无法转化，直接忽略
//            return;
//        }
//
////        //如果对应的class是一个@SwaggerDisplayEnum修饰的枚举类，获取其中的枚举值
////        Object[] subItemRecords = null;
////        SwaggerDisplayEnum swaggerDisplayEnum = AnnotationUtils
////            .findAnnotation(rawPrimaryType, SwaggerDisplayEnum.class);
////        if (null != swaggerDisplayEnum && Enum.class.isAssignableFrom(rawPrimaryType)) {
////            subItemRecords = rawPrimaryType.getEnumConstants();
////        }
////        if (null == subItemRecords) {
////            return;
////        }
////
////        //从annotation中获取对应的值和描述的变量名
////        String valueName = swaggerDisplayEnum.valueName();
////        String descName = swaggerDisplayEnum.descName();
////        if (StringUtils.isBlank(valueName) || StringUtils.isBlank(descName)) {
////            return;
////        }
//
//        final List<String> displayValues = Arrays.stream(subItemRecords).filter(Objects::nonNull).map(item -> {
//            Class currentClass = item.getClass();
//
//            String value;
//            String desc;
//            try {
//                Field valueField = currentClass.getField(valueName);
//                Field descField = currentClass.getField(descName);
//                valueField.setAccessible(true);
//                descField.setAccessible(true);
//                value = valueField.get(item).toString();
//                desc = descField.get(item).toString();
//            } catch (NoSuchFieldException | IllegalAccessException e) {
//                log.warn("获取枚举的属性和值失败, {}", e.getMessage());
//                return null;
//            }
//            return value + ":" + desc;
//        }).filter(Objects::nonNull).collect(Collectors.toList());
//
//        String joinText = " (" + String.join("; ", displayValues) + ")";
//        try {
//            Field mField = ModelPropertyBuilder.class.getDeclaredField("description");
//            mField.setAccessible(true);
//            joinText = mField.get(context.getBuilder()) + joinText;
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//
//        final ResolvedType resolvedType = context.getResolver().resolve(fieldType);
//        context.getBuilder().description(joinText).type(resolvedType);
    }

    /**
     * 设置默认的example
     */
    private void setDefaultExample(ModelPropertyContext context, Class fieldType) {
        if (Number.class.isAssignableFrom(fieldType)) {
            context.getBuilder().example("1");
        }
        if (Boolean.class.isAssignableFrom(fieldType)) {
            context.getBuilder().example("true");
        }
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return true;
    }
}

