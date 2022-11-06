import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Comment from './comment';
import CommentDetail from './comment-detail';
import CommentUpdate from './comment-update';
import CommentDeleteDialog from './comment-delete-dialog';

const CommentRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<Comment />} />
    <Route path="new" element={<CommentUpdate />} />
    <Route path=":id">
      <Route index element={<CommentDetail />} />
      <Route path="edit" element={<CommentUpdate />} />
      <Route path="delete" element={<CommentDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default CommentRoutes;
