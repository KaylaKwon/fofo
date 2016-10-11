
============================================================
Date	 : 2016-3-24 13:25
Writer 	 : Kyoung-ah Kwon
Classify : Unsolved
Content	 :

 * Limitation: MySQL seems have low compatibility at real service.

 * Expected Solution: Buy a primium service before launching.

============================================================
Date	 : 2016-3-22 12:14
Writer 	 : Kyoung-ah Kwon
Classify : Unsolved
Content	 :

 * Limitation: When I load user's project list at Project.jsp,
 	I can't use the variable that 'getAttribute'd at modal window.
	It needs to be used at foreach function.

 * A Quick but Weak Solution: Store the variable when I load the 'Editor' page, set this data at modal window.

 * Expected Sequential Problem(ESP): Newly add project is not in the list.

 * Expected Solution of ESP:
	1. Add getAttribute function at modal window dynamically
	2. Store the opend tabs to session when new project is gonna added
	-> refresh(or redirect, recall GetProjectEditorController)

============================================================
