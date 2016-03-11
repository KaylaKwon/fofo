/**
 * Writer 		: Kyoung-ah Kwon
 * 
 */


$(document).ready(function() {
	
	listEditableFlag = 0;	// 0: unavailable, 1: available
	
	$(".blockList").sortable({
		cancel:".blockUnsortable"
	});
	
	
	/* 탭 추가 기능 */
/*	$('#btnProjectTabAdd').click(function (e) {
	  	var nextTab = $('#projectTab li').size()+1;
		
		var projectTab = document.getElementById("projectTab");
	  	$('<li role="presentation"><a href="#tab'+nextTab+'" aria-controls="tab'+nextTab+'" role="tab" data-toggle="tab">Tab '+nextTab+'</a></li>').insertBefore('#liProjectTabAdd');
	  	$('<div role="tabpanel" class="tab-pane fade" id="tab'+ nextTab + '">'
	  			+ '<div id="projectContent">'
				+ '<ul class="blockList list-unstyled draggableList blockUnsortable"></ul>'
				+ '<div class="table-hover addBlock">'
				+ '블록 추가 <span id="addBlockGlyp" class="glyphicon glyphicon-plus" aria-hidden="true"></span>'
				+ '</div></div>'
	  			+ '</div>').appendTo('.projectTab-content');
	  	$('#projectTab a:last').tab('show');
//	  	$('#projectTab a:nth-last-child(1)').tab('show');	//자잘한 에러
	});*/

	
	
	
	/* 리모콘 기능 */
	// <![CDATA[
	var name = "#floatMenu";
	var menuYloc = null;
	
//	$(document).ready(function(){
	menuYloc = parseInt($(name).css("top").substring(0,$(name).css("top").indexOf("px")))
	$(window).scroll(function () { 
		offset = menuYloc+$(document).scrollTop()+"px";
		$(name).animate({top:offset},{duration:500,queue:false});
	});
//	}); 
	// ]]>
	
});

jQuery(document).ready(function() {
	
	$("#loadProjectBtn").click(function(e){
		var projectName = $("#loadProjectName").val();
		addTab(projectName);
	});
	
	
	$("#editBlockOrder").click(function(e){
		editBlockOrder($(this));
	});
	
	$("#endEditBlockOrder").click(function(e){
		endEditBlockOrder($(this));
	});

});

$(document).on('click', '#btnProjectTabAdd', function(){
	$('#loadProjectModal').on('shown.bs.modal', function () {
//		  $('#myInput').focus()
	})
//	addTab();
});


$(document).on('click', '.addBlock', function(){
	addBlock($(this));
});



$(document).on('click', '.editBlockBtn', function(){ 
	setEditBlockMode($(this));
});

$(document).on('click', '.endEditBlockBtn', function(){ 
	endEditBlockMode($(this));
});

$(document).on('click', '.delBlockBtn', function(){
	delBlock($(this));
});


/* 새 탭 추가 기능  */
function addTab(projectName){
	var nextTab = $('#projectTab li').size()+1;
	
	var projectTab = document.getElementById("projectTab");
  	$('<li role="presentation"><a href="#'+projectName+'" aria-controls="'+projectName+'" role="tab" data-toggle="tab">'+projectName+'</a></li>').insertBefore('#liProjectTabAdd');
  	
  	if(listEditableFlag == 1){
  		$('<div role="tabpanel" class="tab-pane fade" id="'+ projectName + '">'
  	  			+ '<div id="projectContent">'
  				+ '<ul class="blockList list-unstyled draggableList"></ul>'
  				+ '<div class="table-hover addBlock">'
  				+ '블록 추가 <span id="addBlockGlyp" class="glyphicon glyphicon-plus" aria-hidden="true"></span>'
  				+ '</div></div>'
  	  			+ '</div>').appendTo('.projectTab-content');
	}else{
		$('<div role="tabpanel" class="tab-pane fade" id="'+ projectName + '">'
	  			+ '<div id="projectContent">'
				+ '<ul class="blockList list-unstyled draggableList blockUnsortable"></ul>'
				+ '<div class="table-hover addBlock">'
				+ '블록 추가 <span id="addBlockGlyp" class="glyphicon glyphicon-plus" aria-hidden="true"></span>'
				+ '</div></div>'
	  			+ '</div>').appendTo('.projectTab-content');
	}
  	$("#loadProjectName").val('');
  	
  	$('#projectTab a:last').tab('show');
//  	$('#projectTab a:nth-last-child(1)').tab('show');	//자잘한 에러
  	
  	$(".blockList").sortable({
		cancel:".blockUnsortable"
	});
}



/* 블록 추가 */
function addBlock($addBlock){
//	var blockList = document.getElementById("blockList");	
	var blockList = $addBlock.siblings(".blockList");
	
	
	$('<li class="panel panel-info">'
			+ '<div class="block">'
			+ '<div class="blockMover"><span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span></div>'
			+ '<div class="blockContent"><p></p></div>'
			+ '<input class="btn btn-warning editBlockBtn" type="button" value="수정">'
			+ '<input class="btn btn-success endEditBlockBtn" type="button" value="완료" style="display: none;">'
			+ '<input class="btn btn-danger delBlockBtn" type="button" value="삭제">'
			+ '</div></li>').appendTo(blockList);
	
	if(listEditableFlag == 1){
		editBlockListUpdate();
	}
}



/* 블록 순서 수정 */
function editBlockOrder($this){
	/*var projectTabContent = document.getElementById("projectTabContent");
	var activeTab = $(projectTabContent).children('.tab-pane.active.in');
	var blockList = $(activeTab).children('#projectContent').children('.blockList');*/
	
	listEditableFlag = 1;
	$('.editBlockBtn').attr("disabled","disabled");		//열려있는 탭에 대해서만 하도록 변경? or not?
	$('.endEditBlockBtn').attr("disabled","disabled");
	$('.delBlockBtn').attr("disabled","disabled");
	
//	blockList.removeClass("blockUnsortable");
	$('.blockList').removeClass("blockUnsortable");
	
	$this.hide();
	$('#endEditBlockOrder').show();
}
function editBlockListUpdate(){
	$('.editBlockBtn').attr("disabled","disabled");
	$('.endEditBlockBtn').attr("disabled","disabled");
	$('.delBlockBtn').attr("disabled","disabled");
	
}

/* 블록 순서 수정 완료 */
function endEditBlockOrder($this){
	/*var projectTabContent = document.getElementById("projectTabContent");
	var activeTab = $(projectTabContent).children('.tab-pane.active.in');
	var blockList = $(activeTab).children('#projectContent').children('.blockList');*/
	
	listEditableFlag = 0;
	$('.editBlockBtn').removeAttr( "disabled" );
	$('.endEditBlockBtn').removeAttr( "disabled" );
	$('.delBlockBtn').removeAttr( "disabled" );
	
//	blockList.addClass("blockUnsortable");
	$('.blockList').addClass("blockUnsortable");
	
	$this.hide();
	$('#editBlockOrder').show();
}






/* 블록 내용 수정 */
function setEditBlockMode($editBtn) {
	
	var endEditBtn = $editBtn.siblings(".endEditBlockBtn");
	
	var contentObj = $editBtn.siblings(".blockContent");
	var content = $editBtn.siblings(".blockContent").html();
//	var block = $editBtn.parent();
	var editor = $('<div class="summernote">'+content+'</div>');
	editor.insertBefore($editBtn);	 
	
	var summernote = $editBtn.siblings(".summernote");
	
	/* 에디터 초기 설정 */
	summernote.summernote({
		lang : 'ko-KR' // default: 'en-US'
	});
	
	
	contentObj.remove();

	$editBtn.hide();
	endEditBtn.show();
}

/* 블록 내용 수정 완료 */
function endEditBlockMode($endEditBtn){
	var content = $(".summernote").summernote('code');
	var noteEditor = $endEditBtn.siblings(".note-editor");
	noteEditor.remove();
	
	var editBtn = $endEditBtn.siblings(".editBlockBtn");
	
	var newContent = $('<div class="blockContent">'+ content +'</div>');
	newContent.insertBefore(editBtn);
	
	var summernote = $endEditBtn.siblings(".summernote");
	summernote.remove();
	
	$endEditBtn.hide();
	editBtn.show();
}

/* 블록 삭제 */
function delBlock($delBtn){
	var block = $delBtn.parent().parent();
	console.log(block);
	block.remove();
}

