import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './reaction.reducer';

export const ReactionDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const reactionEntity = useAppSelector(state => state.reaction.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="reactionDetailsHeading">
          <Translate contentKey="blogApp.reaction.detail.title">Reaction</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{reactionEntity.id}</dd>
          <dt>
            <span id="emotion">
              <Translate contentKey="blogApp.reaction.emotion">Emotion</Translate>
            </span>
          </dt>
          <dd>{reactionEntity.emotion}</dd>
          <dt>
            <Translate contentKey="blogApp.reaction.applicationUser">Application User</Translate>
          </dt>
          <dd>{reactionEntity.applicationUser ? reactionEntity.applicationUser.id : ''}</dd>
          <dt>
            <Translate contentKey="blogApp.reaction.blog">Blog</Translate>
          </dt>
          <dd>{reactionEntity.blog ? reactionEntity.blog.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/reaction" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/reaction/${reactionEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default ReactionDetail;
