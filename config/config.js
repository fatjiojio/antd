export default {
    singular: true,
    routes: [{
        path: '/',
        component: '../layout',
        routes: [
          {
            path: '/',
            component: 'Helloworld',
          },
          {
            path: '/helloworld',
            component: 'Helloworld'
          },
          {
            path: '/dashboard',
            routes: [
              { path: '/dashboard/analysis', component: 'Dashboard/Analysis' },
              { path: '/dashboard/monitor', component: 'Dashboard/Monitor' },
              { path: '/dashboard/workplace', component: 'Dashboard/Workplace' },
            ]
          },
         
          {
            path: '/CardGroup',
            component: 'CardGroup',
          },
          {
            path: '/Prolist',
            component: 'Prolist',
          },
          {
            path: '/list',
            routes: [
              { path: '/list/index', component: 'list/index' },
            ]
          },
          {
            path: '/css-modules-with-less',
            routes: [
              { path: '/css-modules-with-less/index', component: 'css-modules-with-less/index' },
            ]
          },
          {
            path: '/css-modules-with-antd',
            routes: [
              { path: '/css-modules-with-antd/index', component: 'css-modules-with-antd/index' },
            ]
          },
        ]
      }],
  }