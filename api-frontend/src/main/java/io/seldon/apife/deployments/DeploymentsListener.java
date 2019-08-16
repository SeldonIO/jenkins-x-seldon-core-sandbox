/*******************************************************************************
 * Copyright 2017 Seldon Technologies Ltd (http://www.seldon.io/)
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
 *******************************************************************************/
package io.seldon.apife.deployments;

import io.seldon.protos.DeploymentProtos.SeldonDeployment;

public interface DeploymentsListener {
	 /**
     * Notification of a change in deployments. DO NOT BLOCK ON THIS METHOD! Long
     * running operations will hold up startup.
     * @param client
     * @param configKey
     * @param configValue
     */
	void deploymentAdded(SeldonDeployment resource);
	void deploymentUpdated(SeldonDeployment resource);
	void deploymentRemoved(SeldonDeployment resource);
}
