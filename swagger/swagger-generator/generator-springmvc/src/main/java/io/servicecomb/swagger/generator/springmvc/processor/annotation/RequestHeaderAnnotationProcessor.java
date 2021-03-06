/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.swagger.generator.springmvc.processor.annotation;

import org.springframework.web.bind.annotation.RequestHeader;

import io.servicecomb.swagger.generator.core.OperationGenerator;
import io.servicecomb.swagger.generator.core.processor.parameter.AbstractParameterProcessor;
import io.swagger.models.parameters.HeaderParameter;

public class RequestHeaderAnnotationProcessor extends AbstractParameterProcessor<HeaderParameter> {
  @Override
  protected HeaderParameter createParameter() {
    return new HeaderParameter();
  }

  @Override
  protected String getAnnotationParameterName(Object annotation) {
    return ((RequestHeader) annotation).name();
  }

  @Override
  protected void fillParameter(Object annotation, OperationGenerator operationGenerator, int paramIdx,
      HeaderParameter parameter) {
    super.fillParameter(annotation, operationGenerator, paramIdx, parameter);

    RequestHeader requestHeader = (RequestHeader) annotation;
    parameter.setRequired(requestHeader.required());
  }
}
