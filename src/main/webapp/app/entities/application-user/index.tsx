import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import ApplicationUser from './application-user';
import ApplicationUserDetail from './application-user-detail';
import ApplicationUserUpdate from './application-user-update';
import ApplicationUserDeleteDialog from './application-user-delete-dialog';

const ApplicationUserRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<ApplicationUser />} />
    <Route path="new" element={<ApplicationUserUpdate />} />
    <Route path=":id">
      <Route index element={<ApplicationUserDetail />} />
      <Route path="edit" element={<ApplicationUserUpdate />} />
      <Route path="delete" element={<ApplicationUserDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default ApplicationUserRoutes;
