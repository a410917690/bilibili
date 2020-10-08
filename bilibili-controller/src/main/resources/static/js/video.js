$(function () {
    console.log(" %c 该项目基于Dplayer.js", 'color:red')
    var dp = new DPlayer({
        element: document.getElementById('player1'),
        video: {
            url: 'http://m.yyets8.com/play/72058-1-1.html',
            pic: 'images/lo.png'
        },
        danmaku: {
            id: 'demo',
            api: 'https://api.prprpr.me/dplayer/',
            addition: ['https://api.prprpr.me/dplayer/bilibili?aid=15572523']
        }
    });

    // 弹出框
    function alert_back(text) {
        $(".alert_back").html(text).show();
        setTimeout(function () {
            $(".alert_back").fadeOut();
        }, 1200)
    }

    //秒转分秒
    function formatTime(seconds) {
        return [
//            parseInt(seconds / 60 / 60),
            parseInt(seconds / 60 % 60),
            parseInt(seconds % 60)
        ]
            .join(":")
            .replace(/\b(\d)\b/g, "0$1");
    }

    $.ajax({
        url: "https://api.prprpr.me/dplayer/bilibili?aid=15572523",
        success: function (data) {
            if (data.code == "1") {
                var danmaku = data.danmaku;
                var autor = "农民";
                $(".danmuku_num").text(danmaku.length)
                $(danmaku).each(function (index, item) {
                    if (item.type == "right") {
                    } else {
                        autor = "地主"
                    }
                    var oLi = `   <ol class="danmuku_list" time="${item.time}">
            <li>${formatTime(item.time)}</li>
            <li title="${item.text}">${item.text}</li>
            <li>${autor}</li>
</ol>
`
                    $(".list_ovefiow").append(oLi);
                    autor = "农民";
                })
            } else {
                alert_back("弹幕加载失败 -v-!");
            }
            $(".danmuku_list").on("click", function () {

                dp.seek($(this).attr("time"))
            })
        }
    })
});