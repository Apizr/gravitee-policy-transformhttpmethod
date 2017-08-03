/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.apizr.gravitee.policy;

import io.gravitee.gateway.api.ExecutionContext;
import io.gravitee.gateway.api.Request;
import io.gravitee.gateway.api.Response;
import io.gravitee.policy.api.PolicyChain;
import io.gravitee.policy.api.annotations.OnRequest;

@SuppressWarnings("unused")
public class HttpMethodTransformPolicy {

    /**
     * The associated configuration to this VerbTransform Policy
     */
    private HttpMethodTransformPolicyConfiguration configuration;

    /**
     * @param configuration the associated configuration to the new VerbTransform Policy instance
     */
    public HttpMethodTransformPolicy(HttpMethodTransformPolicyConfiguration configuration) {
        this.configuration = configuration;
    }

    @OnRequest
    public void onRequest(Request request, Response response, ExecutionContext executionContext, PolicyChain policyChain) {
        executionContext.setAttribute(ExecutionContext.ATTR_REQUEST_METHOD, this.configuration.getHttpMethod());

        // Finally continue chaining
        policyChain.doNext(request, response);
    }
}
