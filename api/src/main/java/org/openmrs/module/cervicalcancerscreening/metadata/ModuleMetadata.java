/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.cervicalcancerscreening.metadata;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.springframework.stereotype.Component;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.*;

/**
 * Example metadata bundle
 */
@Component
public class ModuleMetadata extends AbstractMetadataBundle {

	public static class _EncounterType {
		public static final String CERVICAL_CANCER_SCREENING = "3fefa230-ea10-45c7-b62b-b3b8eb7274bb";
	}

	public static class _Form {
		public static final String CERVICAL_CANCER_SCREENING_FORM = "0c93b93c-bfef-4d2a-9fbe-16b59ee366e7";
		public static final String CERVICAL_CANCER_SCREENING_ASSESSMENT_FORM = "48f2235ca-cc77-49cb-83e6-f526d5a5f174";
	}

	/**
	 * @see org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle#install()
	 */
	@Override
	public void install() {
		install(encounterType("Cervical cancer screening", "Cervical cancer screening", _EncounterType.CERVICAL_CANCER_SCREENING));

		install(form("Cervical cancer Screening form", null, _EncounterType.CERVICAL_CANCER_SCREENING, "1", _Form.CERVICAL_CANCER_SCREENING_FORM));
		install(form("Cervical cancer Screening Assessment form", null, _EncounterType.CERVICAL_CANCER_SCREENING, "1", _Form.CERVICAL_CANCER_SCREENING_ASSESSMENT_FORM));
	}
}