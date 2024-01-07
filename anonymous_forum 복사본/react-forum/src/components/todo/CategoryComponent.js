//import { getCategory } from '../../api/todoApi';
import useCustomMove from '../hooks/useCustomMove';
import './CategoryComponent.css';

const CategoryComponent = (props) => {
  const { moveToCate } = useCustomMove();
  return (
    <div className="categoryWarp">
      <div
        className="categoryContent"
        onClick={() => {
          props.setCode(1);
          moveToCate(1);
        }}
      >
        수업
      </div>
      <div
        className="categoryContent"
        onClick={() => {
          props.setCode(2);
          moveToCate(2);
        }}
      >
        교사
      </div>
      <div
        className="categoryContent"
        onClick={() => {
          props.setCode(3);
          moveToCate(3);
        }}
      >
        학생
      </div>
      <div
        className="categoryContent"
        onClick={() => {
          props.setCode(4);
          moveToCate(4);
        }}
      >
        잡담
      </div>
    </div>
  );
};

export default CategoryComponent;
