/**
 * Created by 85181 on 2018/11/16.
 */
$(function () {
    $('#dg').datagrid({
        url: contextPath + '/rdetail/list',
        striped: true,
        loadMsg: 'loading.....',
        pagination: true,
        rownumbers: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [3, 5, 10],
        fit: true,
        fitColumns:true,
        columns: [[
            // -房间编号、客户姓名、身份证号、入住时间、退宿时间、入住天数、总价、登记时间、是否退宿、操作按钮。
            /*rdid int primary key auto_increment,
             rdnum varchar(20),
             rdidcard varchar(20),
             intime datetime,
             outtime datetime,
             days int,
             sum int,
             logintime datetime,
             status int*/
            {title: "房间编号", field: "rdid"},
            {title: "客户姓名", field: "rdnum",align:"center",width:150},
            {title: "身份证号", field: "rdidcard",align:"center",width:150},
            {title: "入住时间", field: "intime",align:"center",width:150},
            {title: "退宿时间", field: "outtime",align:"center",width:150},
            {title: "入住天数", field: "days",align:"center",width:150},
            {title: "总价", field: "sum",align:"center",width:150},
            {title: "登记时间", field: "logintime",align:"center",width:150},
            {title: "是否退宿", field: "status",align:"center",width:150,formatter:function (value,row,index) {
                if (row.status==0){
                   return  "是";
                }
                if(row.status==1){
                    return "否";
                }
            }},
            {title: "操作", field: "do" ,align:"center",width:100,formatter:function (value,row,index) {

                return "<button onclick='returnbike(\""+row.rdid+"\")'>退宿</button>";
            }}
        ]],
        toolbar: '#dg-toolbar'


    });
})



function returnbike(rdid) {
    $.post(contextPath+"/rdetail/return","rdid="+rdid,function (data) {
        $('#dg').datagrid("reload");
        $.messager.show({
            title:'我的消息',
            msg:data.msg,
            timeout:5000,
            showType:'slide'
        });
    },"json")
}

function add() {
    $("#emp-dialog").dialog({
        title: '租赁',
        width: 400,
        height: 480,
        closed: false,
        href: contextPath+"/detail/addDetail",
        modal: true,
        buttons:[{
            text:"添加",
            iconCls:'icon-add',
            handler:function () {
                $("#emp-form").form("submit",{
                    url:contextPath+'/rdetail/add',
                    onSubmit:function (p) {
                        p.etoak = "tonight";
                        //验证emp-form表单项是否非空
                        return $("#emp-form").form("validate");
                    },
                    //参数不处理json
                    success:function (msg) {
                        var data = $.parseJSON(msg);
                        if(data.code === 200){
                            $("#emp-dialog").dialog("close");
                            $("#emp-dialog").dialog("clear");
                            $('#dg').datagrid("reload");

                        }
                        $.messager.show({
                            title:'我的消息',
                            msg:data.msg,
                            timeout:5000,
                            showType:'slide'
                        });
                    }
                });

            }
        }]
    })

}