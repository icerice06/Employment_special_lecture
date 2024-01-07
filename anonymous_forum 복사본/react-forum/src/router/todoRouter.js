import { Suspense, lazy } from 'react';
import { Navigate } from 'react-router-dom';

const Loading = <div>Loading...</div>;
const TodoList = lazy(() => import('../pages/todo/ListPage'));
const TodoRead = lazy(() => import('../pages/todo/ReadPage'));
const TodoAdd = lazy(() => import('../pages/todo/AddPage'));
const TodoModify = lazy(() => import('../pages/todo/ModifyPage'));

const todoRouter = () => {
  return [
    {
      path: 'api',
      element: (
        <Suspense fallback={Loading}>
          <TodoList />
        </Suspense>
      ),
    },
    {
      path: 'api/category/:code',
      element: (
        <Suspense fallback={Loading}>
          <TodoList />
        </Suspense>
      ),
    },
    {
      path: '',
      element: <Navigate replace to="api" />,
    },
    {
      path: 'read/:tno',
      element: (
        <Suspense fallback={Loading}>
          <TodoRead />
        </Suspense>
      ),
    },
    {
      path: 'api/register',
      element: (
        <Suspense fallback={Loading}>
          <TodoAdd />
        </Suspense>
      ),
    },
    {
      path: 'modify/:tno',
      element: (
        <Suspense fallback={Loading}>
          <TodoModify />
        </Suspense>
      ),
    },
  ];
};

export default todoRouter;
