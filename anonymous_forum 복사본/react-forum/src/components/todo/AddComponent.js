import { useState } from 'react';
import { postAdd } from '../../api/todoApi';
import ResultModal from '../common/ResultModal';
import useCustomMove from '../hooks/useCustomMove';
import './AddComponent.css';

const initState = {
  title: '',
  writer: '',
  password: '',
  content: '',
  category: '',
  regDate: '',
  detailed_code: '',
};

const AddComponent = () => {
  const [todo, setTodo] = useState({ ...initState });

  const [result, setResult] = useState(null); //결과 상태

  const { moveToList } = useCustomMove(); //useCustomMove 활용

  const handleChangeTodo = (e) => {
    todo[e.target.name] = e.target.value;
    setTodo({ ...todo });
  };

  const handleClickAdd = () => {
    //console.log(todo)
    postAdd(todo)
      .then((result) => {
        console.log(todo);
        setResult(result.TNO); //결과 데이터 변경
        setTodo({ ...initState });
      })
      .catch((e) => {
        console.error(e);
      });
  };

  const closeModal = () => {
    setResult(null);
    moveToList(); //moveToList( )호출
  };

  return (
    <div className="AddWarp">
      {result ? (
        <ResultModal
          title={'Add Result'}
          content={`New ${result} Added`}
          callbackFn={closeModal}
        />
      ) : (
        <></>
      )}

      <div className="AddTitleWarp">
        <div className="AddTitleContent">
          <input
            className="AddTitleInput"
            name="title"
            type={'text'}
            value={todo.title}
            onChange={handleChangeTodo}
            placeholder="TITLE"
          ></input>
          <dvi className="AddUserWarp">
            <input
              className="AddWriterInput"
              name="writer"
              type={'text'}
              value={todo.writer}
              onChange={handleChangeTodo}
              placeholder="WRITER"
            ></input>
            <input
              className="AddWriterInput"
              name="password"
              type={'text'}
              value={todo.password}
              onChange={handleChangeTodo}
              placeholder="PASSWORD"
            ></input>
          </dvi>
          <div className="AddContentWarp">
            <div className="AddContentContent">
              <textarea
                className="AddContentInput"
                name="content"
                type={'text'}
                value={todo.content}
                onChange={handleChangeTodo}
                placeholder="CONTENT"
              ></textarea>
            </div>
          </div>
          <div className="AddSubContent">
            <div className="AddCartegoryWarp">
              <div className="AddCartegoryContent">
                <select
                  className="AddCartegory"
                  name="category"
                  type={'select'}
                  value={todo.category}
                  onChange={handleChangeTodo}
                >
                  <option className="AddCartegoryOp" value="">
                    CARTEGORY
                  </option>
                  <option className="AddCartegoryOp" value="1">
                    수업
                  </option>
                  <option className="AddCartegoryOp" value="2">
                    교사
                  </option>
                  <option className="AddCartegoryOp" value="3">
                    학생
                  </option>
                  <option className="AddCartegoryOp" value="4">
                    잡담
                  </option>
                </select>
              </div>
            </div>
            <div className="AddButWarp">
              <div className="AddBtnContent">
                <button
                  type="button"
                  className="AddBtn"
                  onClick={handleClickAdd}
                >
                  ADD
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddComponent;
