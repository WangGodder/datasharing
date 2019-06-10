let TopColumn = {
    name: "top-column",
    props: {
        username: {
            type: String,
            default: ''
        }
    },
    data() {
        return {
            search_content: '',
            has_login: true
        }
    },
    methods: {
        goHome: function() {
          window.location.href = "/";
        },
        searchContent: function () {
            alert(this.search_content);
        },
        go_fileStore: function() {
          window.location.href = "fileStore"
        },
        go_community: function () {
            window.open("")
        },
        go_login: function () {
            window.location.href = 'login'
        },
        go_task: function () {
            alert("123")
            $.ajax({
                url: 'localhost:8080',
                type: 'POST',
                headers: {
                    "Authorization": "test"
                },
                data: "123",
                dataType: 'json',
                success: function (data) {
                    alert(data)
                },
                error: function () {
                    alert("error")
                }
            });
            alert("321")
        },
        logout: function () {
            sessionStorage.clear();
            window.location.href = '';
        }
    },
    template:
        "<el-menu mode=\"horizontal\" background-color=\"#545c64\" text-color=\"#fff\" active-text-color=\"#82EBFF\">\n" +
        "        <el-menu-item index=\"1\" v-on:click='goHome()'>\n" +
        "            <img src=\"/img/img_logo.jpg\" class=\"img-circle\" style=\"width: 60px\" alt=\"\">\n" +
        "            <span style=\"font-size: 20px\">数据共享平台</span>\n" +
        "        </el-menu-item>\n" +
        "        <el-menu-item index=\"2\">\n" +
        "            <el-input type=\"text\" v-model=\"search_content\" placeholder=\"搜索\" v-on:keyup.enter.native=\"searchContent()\">\n" +
        "                <el-button slot=\"append\" icon=\"el-icon-search\" v-on:click=\"searchContent()\"></el-button>\n" +
        "            </el-input>\n" +
        "        </el-menu-item>\n" +
        "        <el-submenu index=\"3\">\n" +
        "            <template slot=\"title\">数据仓库</template>\n" +
        "            <el-menu-item index=\"3-1\" v-on:click='go_fileStore'>数据仓库</el-menu-item>\n" +
        "            <el-menu-item index=\"3-2\" :disabled=\"this.username === ''\">我的</el-menu-item>\n" +
        "        </el-submenu>\n" +
        "        <el-menu-item index=\"4\" v-on:click=\"go_community()\">\n" +
        "            <template slot=\"title\">数据社区</template>\n" +
        "        </el-menu-item>\n" +
        "        <el-menu-item index=\"5\" v-on:click=\"go_task()\">\n" +
        "            <template slot=\"title\">数据悬赏</template>\n" +
        "        </el-menu-item>\n" +
        "        <el-submenu index=\"6\">\n" +
        "            <template slot=\"title\">入门</template>\n" +
        "            <el-menu-item index=\"6-1\">系统说明</el-menu-item>\n" +
        "            <el-menu-item index=\"6-2\">数据分析</el-menu-item>\n" +
        "        </el-submenu>\n" +
        "        <el-submenu index=\"7\" style=\"float: right\" v-if=\"this.username !== ''\">\n" +
        "            <template slot=\"title\" >\n" +
        "                <img src=\"/img/user-avater.png\" class=\"img-circle\" style=\" width: 60px\" alt=\"\">\n" +
        "            </template>\n" +
        "            <div>\n" +
        "                <h4 style=\"color: white\" class=\"text-center\">{{username}},欢迎登陆</h4>\n" +
        "            </div>\n" +
        "            <el-menu-item index=\"2-1\">主页</el-menu-item>\n" +
        "            <el-menu-item index=\"2-2\">用户设置</el-menu-item>\n" +
        "            <el-menu-item index=\"2-3\" v-on:click='logout'>退出登陆</el-menu-item>\n" +
        "        </el-submenu>\n" +
        "        <el-menu-item index=\"7\" style=\"float: right\" v-if=\"this.username === ''\" v-on:click=\"go_login()\">\n" +
        "            <template slot=\"title\">登陆</template>\n" +
        "        </el-menu-item>\n" +
        "    </el-menu>"
}