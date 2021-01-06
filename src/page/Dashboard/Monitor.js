import React, { useRef } from 'react';
import { PlusOutlined, EllipsisOutlined } from '@ant-design/icons';
import { Button, Tag, Space, Menu, Dropdown } from 'antd';
import ProTable, { TableDropdown } from '@ant-design/pro-table';
import request from 'umi-request';
const columns = [
    {
        dataIndex: 'index',
        valueType: 'indexBorder',
        width: 48,
    },
    {
        title: '标题',
        dataIndex: 'title',
        copyable: true,
        ellipsis: true,
        tip: '标题过长会自动收缩',
        formItemProps: {
            rules: [
                {
                    required: true,
                    message: '此项为必填项',
                },
            ],
        },
        width: '30%',
    },
    {
        title: '状态',
        dataIndex: 'state',
        initialValue: 'open',
        filters: true,
        onFilter: true,
        valueType: 'select',
        valueEnum: {
            all: { text: '全部', status: 'Default' },
            open: {
                text: '未解决',
                status: 'Error',
            },
            closed: {
                text: '已解决',
                status: 'Success',
            },
            processing: {
                text: '解决中',
                status: 'Processing',
            },
        },
    },
    {
        title: '标签',
        dataIndex: 'labels',
        renderFormItem: (_, { defaultRender }) => {
            return defaultRender(_);
        },
        render: (_, record) => (<Space>
        {record.labels.map(({ name, color }) => (<Tag color={color} key={name}>
            {name}
          </Tag>))}
      </Space>),
    },
    {
        title: '创建时间',
        key: 'created_at',
        dataIndex: 'created_at',
        valueType: 'date',
    },
    {
        title: '操作',
        valueType: 'option',
        render: (text, record, _, action) => [
            <a key="editable" onClick={() => {
                var _a;
                (_a = action.startEditable) === null || _a === void 0 ? void 0 : _a.call(action, record.id);
            }}>
        编辑
      </a>,
            <a href={record.url} target="_blank" rel="noopener noreferrer" key="view">
        查看
      </a>,
            <TableDropdown key="actionGroup" onSelect={() => action.reload()} menus={[
                { key: 'copy', name: '复制' },
                { key: 'delete', name: '删除' },
            ]}/>,
        ],
    },
];
const menu = (<Menu>
    <Menu.Item key="1">1st item</Menu.Item>
    <Menu.Item key="2">2nd item</Menu.Item>
    <Menu.Item key="3">3rd item</Menu.Item>
  </Menu>);
export default () => {
    const actionRef = useRef();
    return (<ProTable columns={columns} actionRef={actionRef} request={async (params = {}) => request('https://proapi.azurewebsites.net/github/issues', {
        params,
    })} editable={{
        type: 'multiple',
    }} rowKey="id" search={{
        labelWidth: 'auto',
    }} pagination={{
        pageSize: 5,
    }} dateFormatter="string" headerTitle="高级表格" toolBarRender={() => [
        <Button key="button" icon={<PlusOutlined />} type="primary">
          新建
        </Button>,
        <Dropdown key="menu" overlay={menu}>
          <Button>
            <EllipsisOutlined />
          </Button>
        </Dropdown>,
    ]}/>);
};