function pageClick(k) {
    $(k).parent().find("div").removeClass("active");
    $(k).addClass("active");
    $("#flTitle").text($(k).text());
    var address = $(k).attr("data-src");
    $("iframe").attr("src", address);
}
