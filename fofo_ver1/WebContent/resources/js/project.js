/**
 * Writer 		: Kyoung-ah Kwon
 * 
 */


$(document).ready(function() {
	
	listEditableFlag = 0;	// 0: unavailable, 1: available
	
	$(".blockList").sortable({
		cancel:".blockUnsortable"
	});
	
	
	/* Remote Controller */
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
	
	$("#addProjectBtn").click(function(e){
		var name = $("#addProjectName").val();
		
		$.post("addProject.do",
			{
				projectName: name
			}	
		);
		addNewProject(name);
	});
	
	$("#btnProjectTabAdd").click(function(e){
		var uid = 123;
		
		$.post("loadProjectList.do",
			{
				userId: uid
			}
		);
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

$(document).on('click', '.closeTab', function(){
	closeTab($(this));
});


function closeTab($closeBtn){
	
}


/* Add new project */
function addNewProject(projectName){
	var nextTab = $('#projectTab li').size()+1;
	
	var projectTab = document.getElementById("projectTab");
  	$('<li role="presentation">'
  			+'<a href="#'+projectName+'" aria-controls="'+projectName+'" role="tab" data-toggle="tab">'
  			+projectName
  			+' <span class="closeTab glyphicon glyphicon-remove" aria-hidden="true"></span>'
  			+'</a></li>').insertBefore('#liProjectTabAdd');
  	
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
  	$("#addProjectName").val('');
  	
  	$('#projectTab a:last').tab('show');
//  	$('#projectTab a:nth-last-child(1)').tab('show');	//자잘한 에러
  	
  	$(".blockList").sortable({
		cancel:".blockUnsortable"
	});
}



/* Add new block */
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



/* Edit Block Order */
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
/* Edit Block Order (When new block added during 'edit block order' mode) */
function editBlockListUpdate(){
	$('.editBlockBtn').attr("disabled","disabled");
	$('.endEditBlockBtn').attr("disabled","disabled");
	$('.delBlockBtn').attr("disabled","disabled");
	
}

/* End editing block order */
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






/* Edit block content */
function setEditBlockMode($editBtn) {
	
	var endEditBtn = $editBtn.siblings(".endEditBlockBtn");
	
	var contentObj = $editBtn.siblings(".blockContent");
	var content = $editBtn.siblings(".blockContent").html();
//	var block = $editBtn.parent();
	var editor = $('<div class="summernote">'+content+'</div>');
	editor.insertBefore($editBtn);	 
	
	var summernote = $editBtn.siblings(".summernote");
	
	/* Initiate editor */
	summernote.summernote({
		lang : 'ko-KR' // default: 'en-US'
	});
	
	
	contentObj.remove();

	$editBtn.hide();
	endEditBtn.show();
}

/* End editing block mode */
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

/* Delete block */
function delBlock($delBtn){
	var block = $delBtn.parent().parent();
	console.log(block);
	block.remove();
}

