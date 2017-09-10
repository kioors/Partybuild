var TableManaged = function () {
    return {
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }
            // begin first table
            $('#tableList').dataTable({
                "aoColumns": [
                    {
                        "fnRender": function (data, display, row) {
                            // return '<div class="checker"><span><input type="checkbox"  value="1" class="checkboxes"/></span></div>';
                            return '<input type="checkbox"  value="' + data + '" class="checkboxes"/>';
                        }
                    },
                    {"mDataProp": ""},
                    {"mDataProp": "name"},
                    {"mDataProp": "password"},
                    {"mDataProp": "mobile"}
                ],
                "bSort": false,
                "aoColumnDefs": [
                    {
                        sDefaultContent: '',
                        aTargets: ['_all']
                    }
                ],
                "fnRowCallback": function (nRow, aData, iDisplayIndex) {
                    $("td:eq(1)", nRow).html(iDisplayIndex + 1);//设置序号位于第一列，并顺次加一
                    return nRow;
                },
                "aLengthMenu": [
                    [15, 30, 50],
                    [15, 30, 50] // change per page values here
                ],
                // set the initial value
                "iDisplayLength": 15,
                "sDom": "<'row-fluid'<'span6'>r>t<'row-fluid'<'span3'i><'span3'l><'span6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage": {
                    "sProcessing": "处理中...",
                    "sLengthMenu": "每页显示 _MENU_ 条",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索:",
                    "sUrl": "",
                    "sEmptyTable": "表中数据为空",
                    "sLoadingRecords": "载入中...",
                    "sInfoThousands": ",",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "上页",
                        "sNext": "下页",
                        "sLast": "末页"
                    },
                    "oAria": {
                        "sSortAscending": ": 以升序排列此列",
                        "sSortDescending": ": 以降序排列此列"
                    }
                },
                "bProcessing": false, // 是否显示取数据时的那个等待提示
                "bServerSide": true,//这个用来指明是通过服务端来取数据
                "sAjaxSource": "/test/tableDemoAjax",//这个是请求的地址
                "fnServerData": retrieveData // 获取数据的处理函数
            });

            jQuery('#tableList .group-checkable').change(function () {
                var set = jQuery(this).attr("data-set");
                var checked = jQuery(this).is(":checked");
                jQuery(set).each(function () {
                    if (checked) {
                        $(this).attr("checked", true);
                    } else {
                        $(this).attr("checked", false);
                    }
                });
                jQuery.uniform.update(set);
            });
            jQuery('#sample_1_wrapper .dataTables_filter input').addClass("m-wrap medium"); // modify table search input
            jQuery('select[name="tableList_length"]').addClass("m-wrap small"); // modify table per page dropdown
            jQuery('select[name="tableList_length"]').select2(); // initialzie select2 dropdown

        }

    };

}();

// 3个参数的名字可以随便命名,但必须是3个参数,少一个都不行
function retrieveData(sSource111, aoData111, fnCallback111) {
    $.ajax({
        url: sSource111,//这个就是请求地址对应sAjaxSource
        data: {"aoData": JSON.stringify(aoData111), "status": "mystatus", "username": $("#username").val()},//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
        type: 'post',
        dataType: 'json',
        async: false,
        success: function (result) {
            fnCallback111(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
            // $(".checkboxes").parent("span").parent("div").addClass("checker");
            // if($(".checkboxes:first").parent().find("span").length==0){
            //     $(".checkboxes").wrap("<div class='checker'><span></span></div>")
            // }
            // refreshList();
        },
        error: function (msg) {
        }
    });
}

// $(function () {
//     $("#checkbox-all").click(function(event){
//         console.log(this)
//         event.stopPropagation();//阻止事件冒泡即可
//         checkAll(this);
//     });
//     $("td").unbind("click");
// })

// //全选
// function checkAll(obj){
//     $("input [name='checkbox-group']").each(function(i){
//         this.parent("span").removeClass("checked");
//         this.checked = obj.checked;
//         if(obj.checked){
//             this.parent("span").addClass("checked");
//         }
//     });
// }
//刷新列表
function refreshList() {
    $("#tableList").dataTable().fnPageChange('refresh');
    // $("#tableList").dataTable().ajax.reload();;
}