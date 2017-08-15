package com.tp.shiro.swagger;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by tupeng on 2017/7/26.
 */
@Data
public class SwaggerJsonConfig {

    private String swagger = "2.0"; //swagger 版本 默认2.0

    private SwaggerInfo info;

    private String host;

    private String basePath;

    public List<ApiTags> tags;

    private List<String> schemes;

    private Map<String, Map<String, SwaggerPathConfig>> paths;

    private Object securityDefinitions;

    private Map<String, BeanConfig> definitions;

    private ExternalDocs externalDocs;

    @Data
    public class ExternalDocs {

        private String description;

        private String url;

    }

    @Data
    public class BeanConfig{

        private String type;

        private Map<String, PropertyConfig> properties;

        public Map<String, ResponseConfig> ApiResponse;

        @Data
        public class ResponseConfig{

            private String type;

            private Map<String, PropertyConfig> properties;

        }

        @Data
        public class PropertyConfig {

            private String type;

            private String format;

        }

    }

    /**
     * 对应访问路径的path配置
     */
    @Data
    public class SwaggerPathConfig {

        private String operationId;

        private String summary;

        private String description;

        private List<String> tags;

        private List<String> consumes;

        private List<String> produces;

        private List<ParamConfig> parameters;

        private Map<String, ResponseConfig> responses;

        private List<Object> security;

        private Boolean deprecated;

        /**
         * response 描述
         */
        @Data
        public class ResponseConfig {

            private String description;

            private ResponseSchema schema;

            @Data
            public class ResponseSchema{

                private String type;

                private SchemaItems items;

                @Data
                public class SchemaItems {

                    private String type;

                }

            }

        }

        /**
         * 参数配置
         */
        @Data
        public class ParamConfig {
            private ParamInType in;

            private String name;

            private String description;

            private Boolean required;

            private PCSchema schema;

            public class PCSchema {

                private String $ref;

            }
        }

    }

    public enum ParamInType {
        body("请求体中"),
        query("路径之后"),
        path("路径中");

        private String name;

        ParamInType(String name) {
            this.name = name;
        }
    }

    /**
     * api tag 列表
     */
    @Data
    public class ApiTags {

        private String name;

        private String description;

    }

    /**
     * swagger 基本信息
     */
    @Data
    public class SwaggerInfo{

        private String title;

        private String version;

        private String termsOfService;

        private String description;

        private  SwaggerContact contact;

        private SwaggerLicense license;

        @Data
        public class SwaggerContact {

            private String email;

        }

        @Data
        public class SwaggerLicense {
            private String name;

            private String url;

        }

    }

}
