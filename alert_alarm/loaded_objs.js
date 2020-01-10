Java.perform(function(){
	Java.enumerateLoadedClasses({
		"onMatch":function(className){
			if(className.includes("AlertAlarm.core")) {
				console.log(className)
			}
		},
		"onComplete":function(){
		}
	})
}) 
