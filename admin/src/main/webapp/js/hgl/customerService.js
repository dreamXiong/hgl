/**
 * 产品详情
 * */
function showdetailsInfo(id){
	 $.ajax({
	        type:"POST",
	        url :"showdetailsInfo",
	        data:{
	        	id:id,
	        },
	        success: function(response){
	        	$("#showdetailsInfo").html(response);
	        }
	 	});
	$("#showdetailsInfo").modal("show");
}  
/**
 * 产品
 * */
function showUpdate(id){
	 $.ajax({
	        type:"POST",
	        url :"showUpdateInfo",
	        data:{
	        	id:id,
	        },
	        success: function(response){
	        	$("#updateProduct").html(response);
	        }
	 	});
	$("#updateProduct").modal("show");
}  
function showAdd(){
	$.ajax({
        type: "POST",
        url: "initializationInfo",
        success: function(response){
        	$("#addProduct").html(response);
        }
    });
	$("#addProduct").modal("show");
}

function delCustomerService(){
	 var id =$("#deleteId").val();
	 $.ajax({
		    type: "POST",
		    url: "delCustomerService",
		    data: "id="+id,
		    success: function(response){
		    	window.location.reload();
		    }
	});
}

function delServiceInfoVal(id){
	 $("#deleteId").val(id);
	 $.ajax({
		    type: "POST",
		    url: "delServiceInfoValidate",
		    data: "id="+id,
		    success: function(response){
		    	if(response.code == '00000'){
		    		$("#deleteProduct").modal("show");
		        }else{
		        	$("#notDeleteProduct").modal("show");
		     }
		    }
		});
}

