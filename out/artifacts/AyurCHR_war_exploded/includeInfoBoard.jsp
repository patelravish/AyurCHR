<script type="text/javascript">
    var loadfeed = function() {
        dojo.byId("mydiv").style.display = 'block';
        dojo.xhrGet({
            // The URL of the request
            url: "common/feed/feed.jsp",
            // Handle the result as JSON data
            handleAs: "text",
            // The success handler
            load: function(data) {
                dojo.byId("mydiv").innerHTML = data;
            },
            // The error handler
            error: function() {
                dojo.byId("newsContainerNode").innerHTML = "News is not available at this time."
            }
        });
        dojo.require("dojox.widget.Portlet");
        dojo.require("dojox.widget.FeedPortlet");
        dojo.require("dijit.dijit");
    };
    var renderwidget = function() {
        dojo.byId('notice').style.display = 'none';
        dojo.parser.parse(dojo.byId('mydiv'));
    };
    dojo.addOnLoad(loadfeed);
    var attachevent = function() {
        dojo.connect(dojo.byId('notice'), "onmouseover", renderwidget);
    };
    dojo.addOnLoad(attachevent);
</script>
<div id='mydiv'>

</div>
<div id='notice' style="vertical-align: middle;margin-left: auto;margin-right: auto;height: 100%;width:900px;"><a
        href="javascript:renderwidget();">Please wait till we load latest Medical Journals for you!</a>
</div>