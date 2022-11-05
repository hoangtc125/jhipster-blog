import React from 'react';
import { Translate } from 'react-jhipster';

import { useAppSelector } from 'app/config/store';

export const TrackerPage = () => {
  const activities = useAppSelector(state => state.administration.tracker.activities);

  return (
    <div>
      <h2>
        <Translate contentKey="tracker.title">Real-time user activities</Translate>
      </h2>
      <table className="table table-sm table-striped table-bordered">
        <thead>
          <tr>
            <th>
              <span>
                <Translate contentKey="tracker.table.userlogin">User</Translate>
              </span>
            </th>
            <th>
              <span>
                <Translate contentKey="tracker.table.ipaddress">IP Address</Translate>
              </span>
            </th>
            <th>
              <span>
                <Translate contentKey="tracker.table.page">Current page</Translate>
              </span>
            </th>
            <th>
              <span>
                <Translate contentKey="tracker.table.time">Time</Translate>
              </span>
            </th>
          </tr>
        </thead>
        <tbody>
          {activities.map((activity, i) => (
            <tr key={`log-row-${i}`}>
              <td>{activity.userLogin}</td>
              <td>{activity.ipAddress}</td>
              <td>{activity.page}</td>
              <td>{activity.time}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TrackerPage;
