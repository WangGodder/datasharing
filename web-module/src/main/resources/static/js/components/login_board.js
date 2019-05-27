let login_board = {
    name: "login_board",
    data() {
        return {
            user_name: '',
            password: '',
            auto_login: false,
        }
    },
    props: {
        service_url: {
            type: String,
            required: true
        },
        register_url: {
            type: String,
            required: true
        },
        forget_password_url: {
            type: String,
            required: true
        }
    },
    methods: {
        login: function () {
            if (this.user_name === "" || this.password === "") {
                this.$notify.error({
                    message: "用户名、密码不能为空",
                    title: "错误"
                });
            }
            let data = {};
            $.ajax({
                url: this.service_url,
                type: 'POST',
                data: {'username': this.user_name, 'password': this.password},
                dataType: 'json',
                success: function (return_data) {
                    // success
                    if (return_data.status == 0) {
                        // console.log(String(return_data.data));
                        if (this.auto_login) {
                            storeJwt(return_data.data);
                        }
                        sessionStorage.setItem("jwt", return_data.data);
                        window.location.href = "/";
                        return;
                    }
                    data =  return_data;
                },
                error: function () {
                    data.status = 5;

                    // $.notify({
                    //     title: "<strong>网络环境问题</strong>",
                    //     message: "网络环境不稳定，请确保网络连接",
                    // }, {
                    //     type: "warn"
                    // });
                }
            });
            // wrong
            if (data.status == 5) {
                this.$notify.error({
                    title: "网络环境问题",
                    message: "网络环境不稳定，请确保网络连接",
                })
            }
            if (data.status == 4) {
                this.password = '';
                $.notify({
                    message: data.message,
                    title: "<strong>登陆失败</strong>"
                }, {
                    type: "danger"
                });
                this.$notify.error( {
                        message: data.message,
                        title: "登陆失败"
                    }
                );
            }
            if (data.status == 2) {
                $.notify({
                    title: "<strong>连接错误</strong>",
                    message: data.message,
                }, {
                    type: "danger"
                })
            }
            if (data.status == 3) {
                $.notify({
                    title: "<strong>连接错误</strong>",
                    message: data.message,
                }, {
                    type: "danger"
                })
            }
        }
    },
    template:
        "    <div class=\"panel panel-default\">\n" +
        "        <div class=\"panel-title\">\n" +
        "            <h3>login</h3>\n" +
        "        </div>\n" +
        "        <br/>\n" +
        "        <div class=\"panel-body\">\n" +
        "            <div>\n" +
        "                <el-input placeholder=\"用户名\" v-model=\"user_name\">\n" +
        "                    <template slot=\"prepend\">账号</template>\n" +
        "                </el-input>\n" +
        "            </div>\n" +
        "            <br/>\n" +
        "            <div>\n" +
        "                <el-input placeholder=\"密码\" show-password v-model=\"password\">\n" +
        "                    <template slot=\"prepend\">密码</template>\n" +
        "                </el-input>\n" +
        "            </div>\n" +
        "            <br/>\n" +
        "            <div class=\"text-left\">\n" +
        "                <el-checkbox v-model=\"auto_login\">7天自动登陆</el-checkbox>\n" +
        "            </div>\n" +
        "            <br/>\n" +
        "            <div class=\"btn btn-block btn-info btn-lg\" v-on:click=\"login()\">登&nbsp;&nbsp;&nbsp;录</div>\n" +
        "            <br/>\n" +
        "            <br/>\n" +
        "            <div class=\"row\">\n" +
        "                <div class=\"text-left col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                    <el-link type=\"primary\" v-bind:href=\"this.register_url\">注册账号</el-link>\n" +
        "                </div>\n" +
        "                <div class=\"text-right col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                    <el-link type=\"warning\" v-bind:href=\"this.forget_password_url\">忘记密码</el-link>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "\n" +
        "    </div>",
};
