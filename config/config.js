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
          //helloworld
          {
            path: '/helloworld',
            component: 'Helloworld'
          },
          //dashboard
          {
            path: '/dashboard',
            routes: [
              { path: '/dashboard/analysis', component: 'Dashboard/Analysis' },
              { path: '/dashboard/monitor', component: 'Dashboard/Monitor' },
              { path: '/dashboard/workplace', component: 'Dashboard/Workplace' },
            ]
          },
         //cardgroup
          {
            path: '/CardGroup',
            component: 'CardGroup',
          },
          //prolist
          {
            path: '/Prolist',
            component: 'Prolist',
          },
          //list
          {
            path: '/list',
            routes: [
              { path: '/list/index', component: 'list/index' },
            ]
          },
          //css-modules-with-less
          {
            path: '/css-modules-with-less',
            routes: [
              { path: '/css-modules-with-less/index', component: 'css-modules-with-less/index' },
            ]
          },
          //css-modules-with-antd
          {
            path: '/css-modules-with-antd',
            routes: [
              { path: '/css-modules-with-antd/index', component: 'css-modules-with-antd/index' },
            ]
          },
           //upload
           {
            path: '/upload',
            component: 'upload',
          },
        ]
      }],
  }