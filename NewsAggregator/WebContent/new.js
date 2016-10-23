function onLoad() {	
	var item = {
		link: "https://www.theguardian.com/politics/2016/oct/22/twice-voters-theresa-may-jeremy-corbyn-economy-brexit-opinium-observer-poll",
		media: "https://i.guim.co.uk/img/media/a6ce293aeca93c55813e9d1fda677b25086d4bc7/4_184_4903_2943/master/4903.jpg?w=620&q=55&auto=format&usm=12&fit=max&s=3208c3a05f810b8e047c0c357d926aa0",
		title: "We are testing titles here",
		description: "If you want to run the same JavaScript on several pages in a web site, you should create an external JavaScript file, instead of writing the same script over and over again. Save the script file with a .js extension, and then refer to it using the src attribute in the <script> tag.",
		category: "Politics"
	}
	
	addItem(item);
}

function addItem(item) {
	var table = $("<table>");
	table.addClass("feed_item");
	
	var tableBody = $("<tbody>");
	table.append(tableBody);
	
	var trBody = $("<tr>");
	trBody.addClass("feed_item_body");
	tableBody.append(trBody);
	
	var tdImg = $("<td>");
	trBody.append(tdImg);
	
	var aImg = $("<a>");
	aImg.attr('href', item.link);
	tdImg.append(aImg);
	
	var img = $("<img>");
	img.attr('src', item.media);
	aImg.append(img);
	
	var tdContent = $("<td>");
	tdContent.addClass("content-wrapper");
	trBody.append(tdContent);
	
	var aTitle = $("<a>");
	aTitle.attr('href', item.link);
	tdContent.append(aTitle);
	
	var title = $("<h3>");
	title.text(item.title);
	aTitle.append(title);
	
	var desc = $("<p>");
	desc.text(item.description);
	tdContent.append(desc);
	
	var trCategory = $("<tr>");
	trCategory.addClass("feed_item_category");
	tableBody.append(trCategory);
	
	var tdCategory = $("<td>");
	tdCategory.attr('colspan', '2');
	trCategory.append(tdCategory);
	
	var divCategory = $("<div>");
	divCategory.attr('style', "background-color:#DC143C");
	divCategory.text(item.category);
	tdCategory.append(divCategory);
	
	$(".feed").append(table);
}

var footerExpanded = false;

function expandFooter() {
	document.getElementById("footer").style.top = "700px";
	footerExpanded = true;
}

function shrinkFooter() {
	document.getElementById("footer").style.top = "950px";
	footerExpanded = false;
}

function handleFooterClick() {
	if (footerExpanded) {
		shrinkFooter()
	} else {
		expandFooter();
	}
}