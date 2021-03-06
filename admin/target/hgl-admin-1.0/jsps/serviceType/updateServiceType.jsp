<%@ page language="java" pageEncoding="UTF-8"%>
<tiles:insert beanName="indexPage">
	<tiles:put name="title" value="分类管理" />
	<tiles:put name="body" type="String">
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>大类修改</title>
	<script src="${ctx}/js/hgl/serviceType.js"></script>   
</head>
<style>
	.errorStyle{
		color: red; 
	}
	.form-control.errorStyleDiv{
	  border:solid 1px red;
	} 
</style>
<body class="skin-blue fixed">
  <div class="content-wrapper">
  	<section class="content-header">
      <h1>
        	我的主页
        <small>大类修改</small>
      </h1>
    </section>
    <section>
    	<div class="col-md-12">
    		<div class="box box-primary">
    			 <div class="box-body">
            <div>
              <a href="index" class="btn btn-primary">返回列表</a>
            </div>
    			 <form id="updateFirstProductType" method="post" action="updateFirstProductType"  class="form-horizontal">
    			<input type="hidden" name="id" value="${serviceType.id}" />
    			<input type="hidden" name="version" value="${serviceType.version}" />
              <div class="form-group">
                <label  class="col-sm-2 control-label">服务大类</label>
                <div class="col-sm-8">
                  <input onchange="updateValidateProductType(${serviceType.id});" onfocus="validateProductTypesRepeat();" name="name" id="productType01" maxlength="30" type="text" class="form-control" value="${serviceType.name }" />
                  <font id="errorText" style="color: red;" ></font>  
                </div>
              </div>
              <div class="form-group">
                <label  class="col-sm-2 control-label">服务描述</label>
                <div class="col-sm-8">
                  <textarea name="describes" id="productType02" maxlength="100" class="form-control" rows="3" >${serviceType.describes }</textarea>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-6 text-right">
                  <button onclick="submitUpdateFirstProductType(${serviceType.id});" type="button" class="btn btn-primary">确定</button>
                </div>
                <div class="col-sm-6 text-left">
                  <button  onclick="goBackServiceIndex();" type="button" class="btn btn-default">取消</button>
                </div>
              </div>
             </form>
    		</div>
    	</div>
    </div>
    </section>
</div>
<script>
  $(function() {
    $('.times').click(function(){
      $(this).datetimepicker('show');
    });
    
  });
</script>
</body>
</html>
</tiles:put>
</tiles:insert>