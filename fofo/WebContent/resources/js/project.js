/**
 * 
 */

/*
$(function () {
	
	
	
});*/


$(document).ready(function() {
	
	listEditableFlag = 0;	// 0: unavailable, 1: available
	
	$("#blockList").sortable({
		cancel:".blockUnsortable"
	});
	
	
	/* 블록 추가 기능 */
	$('#addBlock').click(function(e) {
		
		var blockList = document.getElementById("blockList");	
		
		/*$('<li class="panel panel-info">'
				+ '<div class="block">'
				+ '<div class="summernote"></div> '
				+ '<input class="btn btn-warning" type="button" value="수정">'
				+ '<input class="btn btn-danger" type="button" value="삭제">'
				+ '</div></li>').appendTo('#blockList');*/
		
		$('<li class="panel panel-info">'
				+ '<div class="block">'
				+ '<div class="blockMover"><span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span></div>'
				+ '<div class="blockContent"><p></p></div>'
				+ '<input class="btn btn-warning editBlockBtn" type="button" value="수정">'
				+ '<input class="btn btn-success endEditBlockBtn" type="button" value="완료" style="display: none;">'
				+ '<input class="btn btn-danger delBlockBtn" type="button" value="삭제">'
				+ '</div></li>').appendTo('#blockList');
		
		if(listEditableFlag == 1){
			editBlockListUpdate();
		}
		
	});	

	
	
	
	/* 탭 추가 기능 */
	$('#btnProjectTabAdd').click(function (e) {
	  	var nextTab = $('#projectTab li').size()+1;
		
		var projectTab = document.getElementById("projectTab");
	  	$('<li role="presentation"><a href="#tab'+nextTab+'" aria-controls="tab'+nextTab+'" role="tab" data-toggle="tab">Tab '+nextTab+'</a></li>').insertBefore('#liProjectTabAdd');
	  	$('<div role="tabpanel" class="tab-pane fade" id="tab'+nextTab+'">tab' +nextTab+' content</div>').appendTo('.projectTab-content');
	  	$('#projectTab a:last').tab('show');
//	  	$('#projectTab a:nth-last-child(1)').tab('show');	//자잘한 에러
	});

	
	
	
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
	
//	$('#blockList').sortable();
	
	
	
	
/*	$('.editBlockBtn').click(function(e){
		setEditMode($(this));
	});
	
	$('.endEditBlockBtn').click(function(e){
		endEditMode($(this));
	});*/
	
	
	$("#editBlockOrder").click(function(e){
		editBlockOrder($(this));
	});
	
	$("#endEditBlockOrder").click(function(e){
		endEditBlockOrder($(this));
	});

});



$(document).on('click', '.editBlockBtn', function(){ 
	setEditMode($(this));
});

$(document).on('click', '.endEditBlockBtn', function(){ 
	endEditMode($(this));
});


/* 블록 순서 수정 */
function editBlockOrder($this){
	listEditableFlag = 1;
	$('.editBlockBtn').attr("disabled","disabled");
	$('.endEditBlockBtn').attr("disabled","disabled");
	$('.delBlockBtn').attr("disabled","disabled");
	
//	$('#blockList').sortable();
	$('#blockList').removeClass("blockUnsortable");
	
	$this.hide();
	$('#endEditBlockOrder').show();
}
function editBlockListUpdate(){
	$('.editBlockBtn').attr("disabled","disabled");
	$('.endEditBlockBtn').attr("disabled","disabled");
	$('.delBlockBtn').attr("disabled","disabled");
	
//	$('#blockList').sortable();
	
	
}

/* 블록 순서 수정 완료 */
function endEditBlockOrder($this){
	listEditableFlag = 0;
	$('.editBlockBtn').removeAttr( "disabled" );
	$('.endEditBlockBtn').removeAttr( "disabled" );
	$('.delBlockBtn').removeAttr( "disabled" );
	
	/*$('#blockList').sortable({
		cancel: '.nosort'
	});*/
	/*$("#blockList").sortable({
	    sort: function() {
	            return false;
	    }
	});*/
	
	$('#blockList').addClass("blockUnsortable");
	
	$this.hide();
	$('#editBlockOrder').show();
}


/* 블록 내용 수정 */
function setEditMode($editBtn) {
	
	var endEditBtn = $editBtn.siblings(".endEditBlockBtn");
	
	var contentObj = $editBtn.siblings(".blockContent");
	var content = $editBtn.siblings(".blockContent").html();
//	var block = $editBtn.parent();
	var editor = $('<div class="summernote">'+content+'</div>');
	editor.insertBefore($editBtn);	 
	
	var summernote = $editBtn.siblings(".summernote");
//	summernote.summernote();
//	$('.summernote').summernote();
	/* 에디터 초기 설정 */
	summernote.summernote({
		lang : 'ko-KR' // default: 'en-US'
	});
	
	
	contentObj.remove();

	$editBtn.hide();
	endEditBtn.show();
}

/* 블록 내용 수정 완료 */
function endEditMode($endEditBtn){
	var content = $(".summernote").summernote('code');
	var noteEditor = $endEditBtn.siblings(".note-editor");
	noteEditor.remove();
//	$('.note-editor').remove();
	
	var editBtn = $endEditBtn.siblings(".editBlockBtn");
	
	var newContent = $('<div class="blockContent">'+ content +'</div>');
	newContent.insertBefore(editBtn);
	
	var summernote = $endEditBtn.siblings(".summernote");
	summernote.remove();
//	$('.summernote').remove();
	
	$endEditBtn.hide();
	editBtn.show();
}

