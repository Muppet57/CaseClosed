	var aliasConfig = {
appName : ["", "", ""],
totalPageCount : [],
largePageWidth : [],
largePageHeight : [],
normalPath : [],
largePath : [],
thumbPath : [],

ToolBarsSettings:[],
TitleBar:[],
appLogoIcon:["appLogoIcon"],
appLogoLinkURL:["appLogoLinkURL"],
bookTitle : [],
bookDescription : [],
ButtonsBar : [],
ShareButton : [],
ShareButtonVisible : ["socialShareButtonVisible"],
ThumbnailsButton : [],
ThumbnailsButtonVisible : ["enableThumbnail"],
ZoomButton : [],
ZoomButtonVisible : ["enableZoomIn"],
FlashDisplaySettings : [],
MainBgConfig : [],
bgBeginColor : ["bgBeginColor"],
bgEndColor : ["bgEndColor"],
bgMRotation : ["bgMRotation"],
backGroundImgURL : ["mainbgImgUrl","innerMainbgImgUrl"],
pageBackgroundColor : ["pageBackgroundColor"],
flipshortcutbutton : [],
BookMargins : [],
topMargin : [],
bottomMargin : [],
leftMargin : [],
rightMargin : [],
HTMLControlSettings : [],
linkconfig : [],
LinkDownColor : ["linkOverColor"],
LinkAlpha : ["linkOverColorAlpha"],
OpenWindow : ["linkOpenedWindow"],
searchColor : [],
searchAlpha : [],
SearchButtonVisible : ["searchButtonVisible"],

productName : [],
homePage : [],
enableAutoPlay : ["autoPlayAutoStart"],
autoPlayDuration : ["autoPlayDuration"],
autoPlayLoopCount : ["autoPlayLoopCount"],
BookMarkButtonVisible : [],
googleAnalyticsID : ["googleAnalyticsID"],
OriginPageIndex : [],	
HardPageEnable : ["isHardCover"],	
UIBaseURL : [],	
RightToLeft: ["isRightToLeft"],	

LeftShadowWidth : ["leftPageShadowWidth"],	
LeftShadowAlpha : ["pageShadowAlpha"],
RightShadowWidth : ["rightPageShadowWidth"],
RightShadowAlpha : ["pageShadowAlpha"],
ShortcutButtonHeight : [],	
ShortcutButtonWidth : [],
AutoPlayButtonVisible : ["enableAutoPlay"],	
DownloadButtonVisible : ["enableDownload"],	
DownloadURL : ["downloadURL"],
HomeButtonVisible :["homeButtonVisible"],
HomeURL:['btnHomeURL'],
BackgroundSoundURL:['bacgroundSoundURL'],
//TableOfContentButtonVisible:["BookMarkButtonVisible"],
PrintButtonVisible:["enablePrint"],
toolbarColor:["mainColor","barColor"],
loadingBackground:["mainColor","barColor"],
BackgroundSoundButtonVisible:["enableFlipSound"],
FlipSound:["enableFlipSound"],
MiniStyle:["userSmallMode"],
retainBookCenter:["moveFlipBookToCenter"],
totalPagesCaption:["totalPageNumberCaptionStr"],
pageNumberCaption:["pageIndexCaptionStrs"]
};
var aliasLanguage={
frmPrintbtn:["frmPrintCaption"],
frmPrintall : ["frmPrintPrintAll"],
frmPrintcurrent : ["frmPrintPrintCurrentPage"],
frmPrintRange : ["frmPrintPrintRange"],
frmPrintexample : ["frmPrintExampleCaption"],
btnLanguage:["btnSwicthLanguage"],
btnTableOfContent:["btnBookMark"]
}
;
	var bookConfig = {
	appName:'flippdf',
	totalPageCount : 0,
	largePageWidth : 1080,
	largePageHeight : 1440,
	normalPath : "files/page/",
	largePath : "files/large/",
	thumbPath : "files/thumb/",
	
	ToolBarsSettings:"",
	TitleBar:"",
	appLogoLinkURL:"",
	bookTitle:"FLIPBUILDER",
	bookDescription:"",
	ButtonsBar:"",
	ShareButton:"",
	
	ThumbnailsButton:"",
	ThumbnailsButtonVisible:"Show",
	ZoomButton:"",
	ZoomButtonVisible:"Yes",
	FlashDisplaySettings:"",
	MainBgConfig:"",
	bgBeginColor:"#cccccc",
	bgEndColor:"#eeeeee",
	bgMRotation:45,
	pageBackgroundColor:"#FFFFFF",
	flipshortcutbutton:"Show",
	BookMargins:"",
	topMargin:10,
	bottomMargin:10,
	leftMargin:10,
	rightMargin:10,
	HTMLControlSettings:"",
	linkconfig:"",
	LinkDownColor:"#808080",
	LinkAlpha:0.5,
	OpenWindow:"_Blank",

	BookMarkButtonVisible:'true',
	productName : 'Demo created by Flip PDF',
	homePage : 'http://www.flipbuilder.com/',
	isFlipPdf : "true",
	TableOfContentButtonVisible:"true",
	searchTextJS:'javascript/search_config.js',
	searchPositionJS:undefined
};
	
	
	;bookConfig.loadingCaption="Loading";bookConfig.loadingCaptionColor="#DDDDDD";bookConfig.loadingBackground="#000000";bookConfig.appLogoIcon="../files/mobile-ext/appLogoIcon.png";bookConfig.HomeURL="%first page%";bookConfig.appLogoOpenWindow="Blank";bookConfig.toolbarColor="#000000";bookConfig.iconColor="#CCCCCC";bookConfig.pageNumColor="#333333";bookConfig.FlipSound="Enable";bookConfig.QRCode="Hide";bookConfig.logoHeight="25";bookConfig.logoPadding="10";bookConfig.logoTop="8";bookConfig.HomeButtonVisible="Hide";bookConfig.ShareButtonVisible="Show";bookConfig.ThumbnailsButtonVisible="Show";bookConfig.thumbnailColor="#333333";bookConfig.thumbnailAlpha="70";bookConfig.ZoomButtonVisible="Yes";bookConfig.BookMarkButtonVisible="Hide";bookConfig.TableOfContentButtonVisible="Hide";bookConfig.bookmarkBackground="#000000";bookConfig.bookmarkFontColor="#cccccc";bookConfig.SearchButtonVisible="Show";bookConfig.leastSearchChar="3";bookConfig.searchFontColor="#000000";bookConfig.PrintButtonVisible="Yes";bookConfig.BackgroundSoundButtonVisible="Enable";bookConfig.BackgroundSoundLoop="-1";bookConfig.AutoPlayButtonVisible="Yes";bookConfig.autoPlayAutoStart="No";bookConfig.autoPlayDuration="9";bookConfig.autoPlayLoopCount="1";bookConfig.minZoomWidth="700";bookConfig.minZoomHeight="518";bookConfig.mouseWheelFlip="yes";bookConfig.DownloadButtonVisible="Hide";bookConfig.bgBeginColor="#E2E2E2";bookConfig.bgEndColor="#E2E2E2";bookConfig.bgMRotation="90";bookConfig.backGroundImgURL="../files/mobile-ext/backGroundImgURL.jpg";bookConfig.LeftShadowWidth="90";bookConfig.LeftShadowAlpha="0.6";bookConfig.RightShadowWidth="55";bookConfig.RightShadowAlpha="0.6";bookConfig.pageBackgroundColor="#E8E8E8";bookConfig.flipshortcutbutton="Show";bookConfig.HardPageEnable="No";bookConfig.RightToLeft="No";bookConfig.flippingTime="0.3";bookConfig.retainBookCenter="Yes";bookConfig.FlipStyle="Flip";bookConfig.showDoublePage="Yes";bookConfig.addPaperCoil="No";bookConfig.topMargin="10";bookConfig.bottomMargin="10";bookConfig.leftMargin="10";bookConfig.rightMargin="10";bookConfig.LinkDownColor="#800080";bookConfig.LinkAlpha="0.2";bookConfig.OpenWindow="Blank";bookConfig.showLinkHint="No";bookConfig.totalPageCount=53;bookConfig.largePageWidth=1324;bookConfig.largePageHeight=1872;bookConfig.bookTitle="Case Closed - Manual de Utilizador";bookConfig.productName="FlipBook Creator";bookConfig.homePage="http://www.flippagemaker.com";bookConfig.searchPositionJS="javascript/search_config.js";bookConfig.searchTextJS="javascript/search_config.js";bookConfig.normalPath="../files/mobile/";bookConfig.largePath="../files/mobile/";bookConfig.thumbPath="../files/thumb/";var language = [];; var pageEditor = [[],[{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.139085",y:"0.185802",width:"0.720957",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"5"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.139085",y:"0.210079",width:"0.720957",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"6"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.139085",y:"0.234369",width:"0.720957",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"9"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.157562",y:"0.258647",width:"0.702479",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"10"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.282925",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"11"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.307203",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"12"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.331480",width:"0.684002",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"12"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.157562",y:"0.355770",width:"0.702479",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"13"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.380048",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"14"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.404326",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"14"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.428604",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"14"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.452882",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"15"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.477159",width:"0.684002",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"15"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.501449",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"15"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.525727",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"16"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.157562",y:"0.550005",width:"0.702479",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"17"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.574283",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"18"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.598560",width:"0.684002",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"18"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.622850",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"18"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.647128",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"19"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.671406",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"19"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.695684",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"20"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.719962",width:"0.684002",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"20"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.744251",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"21"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.768529",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"21"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.157562",y:"0.792807",width:"0.702479",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"22"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.817085",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"23"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.841363",width:"0.684002",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"23"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.865652",width:"0.684002",height:"0.024274"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"24"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.889927",width:"0.684002",height:"0.024280"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"24"}}],[{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.084153",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"25"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.108431",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"25"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.132709",width:"0.684002",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"26"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.156998",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"27"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.157562",y:"0.181276",width:"0.702479",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"28"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.205554",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"29"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.229832",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"29"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.254110",width:"0.684002",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"30"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.278399",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"30"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.302677",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"31"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.326955",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"31"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.351233",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"32"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.375511",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"32"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.157562",y:"0.399789",width:"0.702479",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"33"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.424078",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"35"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.448356",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"36"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.472634",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"37"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.157562",y:"0.496912",width:"0.702479",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"38"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.521190",width:"0.684002",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"39"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.545479",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"39"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.139085",y:"0.569757",width:"0.721797",height:"0.017270"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"40"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.139085",y:"0.587027",width:"0.720957",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"40"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.157562",y:"0.611317",width:"0.702479",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"41"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.635595",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"42"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.659873",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"42"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.684151",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"43"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.708428",width:"0.684002",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"43"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.732718",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"44"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.756996",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"45"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.781274",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"45"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.805552",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"45"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.829829",width:"0.684002",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"46"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.854119",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"47"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.878397",width:"0.684002",height:"0.024277"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"48"}}],[{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.084153",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"49"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.108431",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"50"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.132709",width:"0.684002",height:"0.024290"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"51"}},{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.176040",y:"0.156998",width:"0.684002",height:"0.024278"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionGotoPage",pageIndex:"52"}}],[],[{annotype:"com.mobiano.flipbook.pageeditor.TAnnoLink",location:{x:"0.260028",y:"0.332098",width:"0.382147",height:"0.018850"},action:{triggerEventType:"mouseDown",actionType:"com.mobiano.flipbook.pageeditor.TAnnoActionOpenURL",url:"http://www.dafont.com/pt/simply-rounded.font"}}],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[]];
	bookConfig.hideMiniFullscreen=true;
	if(language&&language.length>0&&language[0]&&language[0].language){
		bookConfig.language=language[0].language;
	}
	
try{
	for(var i=0;pageEditor!=undefined&&i<pageEditor.length;i++){
		if(pageEditor[i].length==0){
			continue;
		}
		for(var j=0;j<pageEditor[i].length;j++){
			var anno=pageEditor[i][j];
			if(anno==undefined)continue;
			if(anno.overAlpha==undefined){
				anno.overAlpha=bookConfig.LinkAlpha;
			}
			if(anno.outAlpha==undefined){
				anno.outAlpha=0;
			}
			if(anno.downAlpha==undefined){
				anno.downAlpha=bookConfig.LinkAlpha;
			}
			if(anno.overColor==undefined){
				anno.overColor=bookConfig.LinkDownColor;
			}
			if(anno.downColor==undefined){
				anno.downColor=bookConfig.LinkDownColor;
			}
			if(anno.outColor==undefined){
				anno.outColor=bookConfig.LinkDownColor;
			}
			if(anno.annotype=='com.mobiano.flipbook.pageeditor.TAnnoLink'){
				anno.alpha=bookConfig.LinkAlpha;
			}
		}
	}
}catch(e){
}
try{
	$.browser.device = 2;
}catch(ee){
}
