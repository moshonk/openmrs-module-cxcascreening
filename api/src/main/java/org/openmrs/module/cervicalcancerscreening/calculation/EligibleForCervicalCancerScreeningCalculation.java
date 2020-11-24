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

package org.openmrs.module.cervicalcancerscreening.calculation;

import java.util.Collection;
import java.util.Map;

import org.openmrs.api.context.Context;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.module.kenyacore.calculation.AbstractPatientCalculation;
import org.openmrs.module.kenyacore.calculation.BooleanResult;
import org.openmrs.module.kenyacore.calculation.PatientFlagCalculation;

/**
 * Adult social work form eligibility calculation
 */

/**
 * Eligibility criteria include:
 * age >= 18 years old
 *
 */
public class EligibleForCervicalCancerScreeningCalculation extends AbstractPatientCalculation
		implements PatientFlagCalculation {

	@Override
	public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> parameterValues, PatientCalculationContext context) {
		CalculationResultMap ret = new CalculationResultMap();

		// Everybody eligible!
		for (int ptId : cohort) {

			boolean genderQualifier = false;
			// get patient's age
			String gender = Context.getPatientService().getPatient(ptId).getGender();
			if ( gender.toUpperCase().startsWith("F")) {
				genderQualifier = true;
			    }

			ret.put(ptId, new BooleanResult(genderQualifier, this));
		}

		return ret;
	}
	@Override
	public String getFlagMessage() {
		return "Eligible for Cervial cancer screening";
	}
}