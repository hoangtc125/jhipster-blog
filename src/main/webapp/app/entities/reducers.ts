import applicationUser from 'app/entities/application-user/application-user.reducer';
import blog from 'app/entities/blog/blog.reducer';
import reaction from 'app/entities/reaction/reaction.reducer';
import comment from 'app/entities/comment/comment.reducer';
import product from 'app/entities/product/product.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

const entitiesReducers = {
  applicationUser,
  blog,
  reaction,
  comment,
  product,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
};

export default entitiesReducers;
