$(function() {

    $.ajax({
    	type: "GET",
    	url: "data.json",
    	async: true,
    	success: function(result){
    		var jsonData = JSON.parse(result);

    		jsonData = jsonData.map(function(a){
				str = JSON.stringify(a);
				str = str.replace(/\"label\":/g, "\"text\":");
				str = str.replace(/\"nested\":/g, "\"children\":");
				a = JSON.parse(str);
    			return a;
    		});

    		createJSTrees(jsonData);
    	}

    });

    function createJSTrees(jsonData) {
	    $("#tree").jstree({
	        "core" : {
	            "data" : jsonData
	        },
	        "types": {
	        	"file": {
	        		"icon": "jstree-file"
	        	},
	        	"dir": {
	        		"icon": "jstree-folder"
	        	}
	        },
	        "plugins": ["types"]
	    });
	}

	$('#tree').on("select_node.jstree", function (e, data) { 
		$("#description").text(data.node.original.description); 
	});
});
