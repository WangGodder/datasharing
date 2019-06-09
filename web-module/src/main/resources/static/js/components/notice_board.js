let Notice_board = {
    name: "notice-board",
    props: {
        notice_info : {
            required: true,
            type: Array
        }
    },
    data: function () {
        return {

        }
    },
    methods: {
        notice_jump: function (url) {
            window.open(url)
        }
    },
    template:
        "<div>\n" +
        "        <el-carousel :interval=\"4000\" type=\"card\" height=\"400px\" style=\"width: 80%\" class=\"center-block\">\n" +
        "            <el-carousel-item v-for=\"item in this.notice_info\">\n" +
        "                <div v-on:click=\"notice_jump(item['url_jump'])\"><img :src=\"item['img_url']\" ></div>\n" +
        "            </el-carousel-item>\n" +
        "        </el-carousel>\n" +
        "    </div>"
}