import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Reaction from './reaction';
import ReactionDetail from './reaction-detail';
import ReactionUpdate from './reaction-update';
import ReactionDeleteDialog from './reaction-delete-dialog';

const ReactionRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<Reaction />} />
    <Route path="new" element={<ReactionUpdate />} />
    <Route path=":id">
      <Route index element={<ReactionDetail />} />
      <Route path="edit" element={<ReactionUpdate />} />
      <Route path="delete" element={<ReactionDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default ReactionRoutes;
