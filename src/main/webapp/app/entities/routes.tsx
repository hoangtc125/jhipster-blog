import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import ApplicationUser from './application-user';
import Blog from './blog';
import Reaction from './reaction';
import Comment from './comment';
import Product from './product';
/* jhipster-needle-add-route-import - JHipster will add routes here */

export default () => {
  return (
    <div>
      <ErrorBoundaryRoutes>
        {/* prettier-ignore */}
        <Route path="application-user/*" element={<ApplicationUser />} />
        <Route path="blog/*" element={<Blog />} />
        <Route path="reaction/*" element={<Reaction />} />
        <Route path="comment/*" element={<Comment />} />
        <Route path="product/*" element={<Product />} />
        {/* jhipster-needle-add-route-path - JHipster will add routes here */}
      </ErrorBoundaryRoutes>
    </div>
  );
};
