<%
	ui.decorateWith("kenyaemr", "standardPage", [ patient: patient ])
%>

<div class="ke-page-content">
	${ ui.decorate("kenyaui", "panel", [ heading: "Welcome" ], "Cervical cancer screening home page") }
</div>


<div class="ke-page-sidebar">
	${ ui.includeFragment("kenyaemr", "patient/patientSearchForm", [ defaultWhich: "all" ]) }
	${ ui.includeFragment("kenyaui", "widget/panelMenu", [ heading: "mUzima Queue", items: menuItems ]) }
</div>

<div class="ke-page-content">
	${ ui.includeFragment("kenyaemr", "patient/patientSearchResults", [ pageProvider: "cervicalcancerscreening", page: "cervicalcancerscreening/patientProfile" ]) }
</div>

<script type="text/javascript">
	jQuery(function() {
		jQuery('input[name="query"]').focus();
	});
</script>