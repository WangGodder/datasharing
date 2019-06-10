let DataCard = {
    name: "data-card",
    props: {
        dataFileInfo: {
            required: true,
        }
    },
    methods: {
        goDataFile: function (fileId) {
            alert(fileId);
        },
        findFileByField: function (fieldId) {
            alert(fieldId);

        }
    },
    template:
        "<div class=\"center-block text-center\">\n" +
        "        <el-card>\n" +
        "            <div slot=\"header\" class=\"text-left\">\n" +
        "                <el-badge :value=\"dataFileInfo.tag\" class=\"center-block\">\n" +
        "                    <el-button type=\"text\" size=\"medium\" v-on:click=\"goDataFile(dataFileInfo.fileId)\">\n" +
        "                        {{this.dataFileInfo.fileName}}\n" +
        "                    </el-button>\n" +
        "                </el-badge>\n" +
        "                <el-rate class=\"center-block\" style=\"float: right\" v-model=\"dataFileInfo.level\" disabled show-score></el-rate>\n" +
        "            </div>\n" +
        "            <div class=\"row\">\n" +
        "                <div class=\"col-sm-8 col-md-8 col-lg-8 col-xs-8 text-justify\" style=\"word-break: break-all;white-space: normal\">\n" +
        "                    {{this.dataFileInfo.info}}\n" +
        "                </div>\n" +
        "                <div class=\"col-sm-4 col-md-4 col-lg-4 col-xs-4\">\n" +
        "                    <el-button type=\"primary\" v-for=\"field in dataFileInfo.fields\" v-bind:key=\"field.fieldId\" round v-on:click=\"findFileByField(field.fieldId)\">\n" +
        "                        {{field.fieldName}}\n" +
        "                    </el-button>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--<el-image :src=\"dataInfo['portrait']\" fit=\"fill\"></el-image>-->\n" +
        "            <!--<div>{{dataInfo['info']}}</div>-->\n" +
        "\n" +
        "        </el-card>\n" +
        "    </div>"
}